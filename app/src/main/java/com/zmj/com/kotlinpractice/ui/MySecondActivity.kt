package com.zmj.com.kotlinpractice.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zmj.com.kotlinpractice.R
import com.zmj.com.kotlinpractice.bean.*
import kotlinx.android.synthetic.main.activity_my_second.*
import org.jetbrains.anko.toast

class MySecondActivity : AppCompatActivity(){
    var is_odd :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_second)

        btn_next.setOnClickListener {
            is_odd = !is_odd
            initPuzzle(is_odd)
        }
        btn_getAnswer.setOnClickListener {
            initAnswer(is_odd)
        }

        btn_initPoem.setOnClickListener {
//            initPoem()
//            initPoem1()
//            initPoemWithWhile()
                try{
                    initpoemWithNullString()
                    initAnmial()
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        initEnum(5)

        var count :Int = 2
        btn_data.setOnClickListener {
            var lotus = Plant("莲","莲藕","莲叶","莲花","莲蓬","莲子")
            //copy方法不带参数表示一模一样的复制对象
            var lotus2 = lotus.copy()
            lotus2 = when(count++%2){
                0 -> lotus.copy(flower = "荷花")
                else -> lotus.copy(flower = "莲花")
            }
            //数据类型自带equals方法，用于判断两个对象是否一样
            var result:String = if (lotus.equals(lotus2)) "相同" else "不同"

            toast("比较结果$result \n" + "第一个：${lotus.toString()} \n" + "第二个：${lotus2.toString()}")
        }

        btn_moban.setOnClickListener {
            var  river = when(count++%4){
                //模板类声明对象时，要在模板类的类名中添加<参数类型>
                0 -> River<Int>("小溪",100)
                //如果编译器根据输入参数就能判断参数类型，可以省略 <参数类型>
                1 -> River("瀑布",99.0f)
                2 -> River<Double>("山涧",50.6)
                else -> River("大河","一千")
            }
            tv_puzzleName.text = river.getInfo()
        }

    }

    //加载谜面
    fun initPuzzle(isok:Boolean){
        if (isok){
            tv_puzzleContent.text = "第一个：凉风有信"
        }else{
            tv_puzzleContent.text = "第二个：秋月无边"
        }
    }
    //谜底
    fun initAnswer(isok: Boolean){
        if(isok){
            tv_puzzleAnswer.text = "讽"
        }else{
            tv_puzzleAnswer.setText("二")
        }
    }


    //for循环
    val poemArray:Array<String> = arrayOf("朝辞白帝彩云间", "千里江陵一日还", "两岸猿声啼不住","轻舟已过万重山")
    fun initPoem(){
        var poem :String = ""
        for (item in poemArray){
            poem = "$poem$item,\n"
        }
        tv_poem.text = poem
    }

    fun initPoem1(){
        var poem:String = ""
        for (i in poemArray.indices){
            if(i%2 == 0){
                poem = "$poem ${poemArray[i]},\n"
            }else{
                poem = "$poem${poemArray[i]},。\n"
            }
        }
        tv_poem.text = poem
    }
    fun initPoemWithWhile(){
        var poem:String = ""
        var i : Int = 0
        while (i < poemArray.size){
            if(i % 2 == 0){
                poem = "$poem${poemArray[i]},\n"
            }else{
                poem = "$poem${poemArray[i]}。\n"
            }
            i++
        }
        tv_poem.text = poem
    }
    val poemArray1:Array<String?> = arrayOf("朝辞白帝彩云间",null,"千里江陵一日还","", "两岸猿声啼不住","   ","轻舟已过万重山")
    fun initpoemWithNullString(){
        var poem :String = ""
        var pos :Int = -1
        var count:Int = 0
        while (pos <= poemArray1.size){
            pos++
            if (poemArray1[pos].isNullOrBlank()) continue
            if (count%2 == 0){
                poem = "$poem${poemArray1[pos]},\n"
            }else{
                poem = "$poem${poemArray1[pos]}。\n"
            }
            count++
            if (count == 4) break
        }
        tv_poem.text = poem
    }

    fun initAnmial(){
        var anmial1: WildAnimal = WildAnimal(this,"dog",0)
        //toast("this is ${anmial1.name} sex is ${anmial1.sexName}")
        //调用类中的静态变量
        var sex :Int = WildAnimal.FEMAL

        initChickfun()
    }
    //Chicken的内部方法
    fun initChickfun(){
        var cock:Cock = Cock()
        toast(cock.callOut(8))
    }
    //Goose方法的调用
    fun initGoose(){
        Goose().run()
        Goose().fly()
    }
    //嵌套类内部类
    fun initTree(){
        //使用内部类时，必须调用外部类的构造函数
       var peach = Tree("peachTree").Frut("peachFlower")
        //调用嵌套类的方法
        peach.getName()
    }
    //使用枚举类
    fun initEnum(count:Int){
        btn_enum.setOnClickListener {
            if (count%2 == 0){
                //ordinal表示枚举类型的序号，name表示枚举类型的名称
                tv_puzzleName.text = when(count%4){
                    SeasonType.SPRING.ordinal -> SeasonType.SPRING.name
                    SeasonType.SUMMER.ordinal -> SeasonType.SUMMER.name
                    SeasonType.AUTUMN.ordinal -> SeasonType.AUTUMN.name
                    SeasonType.WINTER.ordinal -> SeasonType.WINTER.name
                    else -> "unkonwn"
                }
            }else{
                tv_puzzleName.text = when(count%4){
                    SeasonName.SPRING.ordinal -> SeasonName.SPRING.name
                    SeasonName.SUMMER.ordinal -> SeasonName.SUMMER.name
                    SeasonName.AUTUMN.ordinal -> SeasonName.AUTUMN.name
                    SeasonName.WINTER.ordinal -> SeasonName.WINTER.name
                    else -> "unknown"
                }
            }
        }
    }
}

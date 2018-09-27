package com.zmj.com.kotlinpractice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zmj.com.kotlinpractice.ui.MyKotlinContinerAct
import com.zmj.com.kotlinpractice.ui.MySecondActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

//D:\AndroidStudio\testprojects\KotlinPractice\app\src\main\res\layout\activity_main.xml
class MainActivity : AppCompatActivity() {
    //变量常量声明
    var s :String = "hello"//变量
    val SVAL :String = "welcome"//常量不可变相当于java中的final修饰的常量

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initText()
        initBtn()
        changeDataType()

        initArray()

        dealWithString()

        btn_nextAct.setOnClickListener {
            //获取Intent对象
            val intent = Intent()
            //设置跳转的目的Activity
            intent.setClass(this,MySecondActivity::class.java)
            //跳转
            startActivity(intent)
        }

        btn_kotlinContiner.setOnClickListener {
            startActivity(Intent(this,MyKotlinContinerAct::class.java))
        }
    }

    fun initText(){
//        tv_test.setText("你好呀")
        tv_test.text = "你好呀"
    }
    fun initBtn(){
        btn_test.setOnClickListener{
            //tv_test.text = "您点击了Button"
//            toast("小提示，您点了一下下")
            longToast("小提示，我是longToast")
        }
        btn_test.setOnLongClickListener { tv_test.text = "您长按了BUtton";true }
    }

    val origin:Float = 65.0f
    //数据类型转换
    fun changeDataType(){
        var int:Int
        btn_toInt.setOnClickListener { int = origin.toInt(); tv_afterChange.text= int.toString() }
        var long:Long
        btn_toLongInt.setOnClickListener { long = origin.toLong();tv_afterChange.text = long.toString() }
        var float:Float
        btn_toFloat.setOnClickListener { float = origin.toFloat();tv_afterChange.text = float.toString() }
        var double:Double
        btn_toDoubleFloat.setOnClickListener { double = origin.toDouble();tv_afterChange.text = double.toString() }
        var boolean:Boolean
        btn_toBoolean.setOnClickListener { boolean = origin.isNaN();tv_afterChange.text = boolean.toString() }
        var char:Char
        btn_toChar.setOnClickListener { char = origin.toChar();tv_afterChange.text = char.toString() }
    }

    //数组
    fun initArray(){
        var int_array:IntArray = intArrayOf(1,2,3)
        var long_array:LongArray = longArrayOf(1,2,3)
        var float_array:Array<Float> = arrayOf(1.0f,2.0f,3.0f)
        var double_array:Array<Double> = arrayOf(1.0,2.0,3.0)
        var boolean_array:Array<Boolean> = arrayOf(true,false,true)
        var char_array:Array<Char> = arrayOf('a','b','c')
        var string_array:Array<String> = arrayOf("how","are","you")

        btn_intArray.setOnClickListener {chainIntArray(int_array) }

        btn_stringArray.setOnClickListener { chainStringArray(string_array) }

//        btn_longIntArray.setOnClickListener { chainArrays(long_array) }
        btn_floatArray.setOnClickListener { chainArrays(float_array) }
        btn_doubledArray.setOnClickListener { chainArrays(double_array) }
        btn_booleanbArray.setOnClickListener { chainArrays(boolean_array) }
        btn_charArray.setOnClickListener { chainArrays(char_array) }
    }

    //泛型函数
    fun <T>chainArrays( array:Array<T>){
        var string :String = ""
        var i = 0
       for (i in array.indices){
           string = "$string${array[i]}"
       }
        tv_arrayElement.text = string
    }

    fun chainIntArray(array: IntArray):String{
        var str = ""
        var i = 0
        while (i < array.size){
            str += array[i].toString() +  ","
            i++
        }
        tv_arrayElement.text= str
        return str
    }
    fun chainStringArray(array:Array<String>){
        var str = ""
        var i = 0
        while (i < array.size){
            str += array[i] + ","
            i++
        }
        tv_arrayElement.text = str
    }

    //处理字符串
    fun dealWithString(){
        btn_dealString.setOnClickListener {
            var origin :String = tv_arrayElement.text.toString().trim()
            cutString(origin)
            splitString()
        }
    }
    fun cutString(string:String){
        if (string.lastIndexOf(',') > 0){
            tv_arrayElement.text = string.substring(0,string.lastIndexOf(','));
        }
    }

    fun splitString(){
        val textString:String = "hwo,are,you"
        var splitList:List<String> = textString.split(",")
        var result:String = ""
        for (item in splitList){
            result += item + "."
        }
        toast("split结果："+ result)
    }


    fun add(a:Int,b:Int):Int{//Int 参数，返回值Int
        return a + b
    }
    public fun sum(a:Int,b:Int):Int = a + b;//public方法必须明确返回类型，表达式

    //可变长参数函数 用varvarg关键字进行标识
    fun vars(vararg v:Int){
        for (vt in v){
            print(vt)
        }
    }
    //测试
    fun main(args:Array<String>){
        vars(1,2,3,4,5)
    }

    //字符串模版
    //$表示一个变量名或者变量值
    //$varName 表示变量值
    //${varName.fun()}表示变量的方法返回值
    fun testA(){
        var a  = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is","was")},but now a is $a"
    }
    //NUll检查机制
    fun checkNull(){
        //类型后加?表示可以为空
        var name :String? = "12"
        //加!!抛空指针异常
        var age = name!!.toInt()
        //加？不作处理，返回null
        var age1 = name?.toInt()
        //加?:遇空时返回 -1
        var age2 = name?.toInt() ?: -1

    }
    //使用一个返回值可以为null的函数
    fun returnNull(args: Array<String>){
        if (args.size < 2){
            print("Two Integers need")
            return
        }
    }

    //    var x = parseInt()
    //比较数据的时候 === 是比较地址    == 是比较值
    fun testCompareData(args: Array<String>){
        var a:Int = 10000
        print(a === a) //true 比较地址 地址相等

        //经过装箱，创建两个不同的对象
        var  boxedA :Int? = a
        var  boxedB :Int? = a

        //经过装箱值不变，但是地址改变
        print(boxedA == boxedB)     //true  比较值
        print(boxedA === boxedB)      //false 地址不同
    }

    //类型转换
    //较小的类型不是较大类型的子类，所以较小类型不能隐式的转换为较大类型
    fun transformType() :Int{
        var b :Byte = 1
        var i :Int = b.toInt() //将Byte类型的转换为Int类型

        var l = 1L + 3   //Long + Int => Long

        //字符定义
        var  c :Char = '1'
        //将字符转换为Int
        if (c !in '0'..'9'){
            throw IllegalArgumentException("Out of range")
        }else{
            return c.toInt() - '0'.toInt()
        }
        //Boolean布尔值
        var isOk :Boolean = false
    }

    //数组 用Array实现
    //并且还有一个 size 属性及 get 和 set 方法 由于使用[]重载了get set 方法，所以可以通过角标方便的设置和读取数据
    //数组的两种创建方式 1.arrayOf（），2.使用工厂函数
    fun testArray(){
        //[1,2,3]
        var a = arrayOf(1,2,3)
        //[0,2,4]   工厂方式
        var b = Array(3,{i -> (i * 2)})

        //读取内容
        print(a[0])     //输出1
        print(b[1])     //输出 2
    }

}

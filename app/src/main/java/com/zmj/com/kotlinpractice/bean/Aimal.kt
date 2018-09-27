package com.zmj.com.kotlinpractice.bean

import android.content.Context
import org.jetbrains.anko.toast

/**
 *Created by ZMJ
 *on 2018/9/3
 */

//定义类包含主构造函数
class Aimal constructor(context: Context,name:String) {
    //kotlin类的初始化函数,主构造函数的内部代码
    init {
        println("初始化的Animal类")
        context.toast("这是一个名字$name")
    }
    //二级构造函数，需要调用主构造函数，this(context,name)
    constructor(context: Context,name: String,sex:Int):this(context,name){
        var sex:String = if (sex == 0) "meal" else "famel"
        context.toast("这是一个${sex}的${name}")
    }
}
//带两个二级构造函数
class AnimalSeparate{
    constructor(context: Context,name: String){
        context.toast("this is ${name}")
    }

    constructor(context: Context,name: String,sex:Int){
        context.toast("this is ${sex} ${name}")
    }
}

//经过优化主构造函数使用默认参数，更加简洁,传入不同个数的参数均能构造AnmialDefault对象
class AnmailDefault(context: Context,name: String,sex: Int){
    init {
        var sexAnimal : String = if (sex == 0) "mael" else "famel"
        context.toast("this is ${sexAnimal}${name}")
    }
}

//创建类的时候即可在构造函数中定义成员变量,这些变量在实例化对象之后即可获取
class WildAnimal(var context: Context,var name: String,val sex: Int=0){

    //如果某个成员并非实例化时入参的同名属性，则需在类中声明此属性 如：
    //非空成员属性必须在声明时赋值或者在构造函数中赋值
    var sexName :String
    init {
        sexName= if (sex == 0) "mael" else "femal"
    }

    //伴生对象，相当于java中的静态代码块
    //在类加载时就运行伴生对象的代码块
    //依次类推，伴生对象能实现静态函数，也就能实现静态属性，只要在伴生对象内部声明属性即可
    companion object WildAnmial{
        //伴生对象的静态属性
        val MALE = 0
        val FEMAL = 1
        val UNKNOWN = -1

        fun judgeSex(sexName:String):Int{
            var sex:Int = when(sexName){
                "meal","maal" -> MALE
                "femal","famel" -> FEMAL
                else -> UNKNOWN
            }
            return sex
        }
    }
}
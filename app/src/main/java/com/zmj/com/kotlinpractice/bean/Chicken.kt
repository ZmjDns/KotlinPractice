package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 */
//子类的构造函数，原来的输入参数不用加var或val，新增的参数必须用var或者val修饰
//因为抽象类不能直接使用，所以构造函数不必给默认参数赋值
abstract class Chicken(name:String,sex:Int,var voice:String):Bird(name,sex) {
    val numberArray:Array<String> = arrayOf("一","二","三","四","五","六","七","八","九","十")
    //抽象方法必须在子类中重写，可以省略关键字open，因为abstract方法默认是哦pen的
    abstract fun callOut(times:Int):String
}
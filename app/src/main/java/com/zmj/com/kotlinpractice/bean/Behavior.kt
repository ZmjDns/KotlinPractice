package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 */
//Kotlin与java一样不允许多继承，但是可以实现多个接口
//接口不允许带构造函数
//与Java不同的是Kotlin接口内部可以实现某个方法
interface Behavior {
    //接口内部方法默认是抽象的，可以不用open和abstract修饰
    open abstract fun  fly():String

    fun swim():String
    //Kotlin接口内部可以实现方法，因此该方法不是abstract的，但是默认为open
    fun run():String{
        return "Most of birds are not good at running ,just a few of them are good at running,such as:TuoNiao,ZheGu"
    }
    //Kotlin的接口允许声明抽象属性，实现该接口的类必须重载该属性
    //与接口内部方法一样，抽象属性前面的open和abstract也可以省略掉
    //open abstract var skilledSports：String
    var skilledSports:String
}
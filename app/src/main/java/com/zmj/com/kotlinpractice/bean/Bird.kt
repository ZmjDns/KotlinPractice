package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/3
 */
//kotlin的默认类是不能被继承的，如果需要被继承则需添加open关键字来修饰该类
open class Bird(var name: String,var sex:Int ) {
    //kotlin修饰方法变量的关键字
    //public:对所有对象开放，如果不加修饰符则默认为public
    //internal：值对本模块开放，对APP来说，本模块表示APP本身
    //protect：只对自己和子类开放：
    //private：只对自己开放，即私有，与修饰类的open不能同时存在
    //变量、方法一般都是默认public 所以一般把public省掉
    var sexName:String
    init {
        sexName = getSexName(sex)
    }

    open protected fun getSexName(sex: Int):String{
        return if(sex == 0) "meal" else "famel"
    }
    fun getDesc(tag:String):String{
        return "welcome to $tag:this is $sexName $name"
    }

    companion object BirdStatic{
        val MALE = 0
        val FAMEL = 1
        val UNKNUWN = -1
        fun judgeSex(sexName:String):Int{
            var sex:Int = when(sexName){
                "MEAL","MEEAL" -> MALE
                "FAMEL","FEMAL" -> FAMEL
                else -> UNKNUWN
            }
            return sex
        }
    }
}
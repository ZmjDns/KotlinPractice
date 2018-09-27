package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 */
class Duck(name:String="duck",sex:Int = Bird.MALE):Bird(name,sex) {
    //继承protected的方法override protected
    //即override protected fun getSexName(sex：Int)：String｛
    //不过protected方法是被继承过来的默认就是protected，所以可以直接省略protected
    //即override fun getSexName（sex：Int）：String｛
    //protected继承后允许升级为public，但是不能降级为private
    override public fun getSexName(sex:Int):String{
        return if(sex == MALE) "MEAL" else "FAMEL"
    }
}
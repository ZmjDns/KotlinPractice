package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 */
class Hen(name:String = "chicken",sex:Int = Bird.MALE,voice:String = "GEGEGE"):Chicken(name, sex, voice) {
    override fun callOut(times: Int): String {
        var count = when{
            times <= 0 -> 0
            times >= 10 -> 9
            else -> times
        }
        return "$sexName$name$voice called out ${numberArray[count]} times"
    }

}
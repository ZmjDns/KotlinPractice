package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 * 模板类，与Java中类似
 */
class River<T>(var name:String,var length:T) {
    fun getInfo():String{
        var unit:String = when(length){
            is String -> "米"
            is Number -> "m"
            else -> ""
        }
        return "$name 的长度是 $length$unit。"
    }
}
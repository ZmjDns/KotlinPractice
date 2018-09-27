package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 * 密封类
 */
sealed class SeasonSealed {
    //密封类的每一个嵌套类都必须继承此类
    class Spring(var name:String):SeasonSealed()
    class Summer(var name: String):SeasonSealed()
    class Autumn(var name: String):SeasonSealed()
    class Winter(var name: String):SeasonSealed()
}
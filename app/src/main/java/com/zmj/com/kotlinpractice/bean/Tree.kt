package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 */
class Tree(var name:String) {
    //Kotlin的嵌套类，不能访问外部成员，
    //访问嵌套累的成员或方法时需要先实例外部对象，通过外部对象名即 外部对象名.嵌套类方法或成员
    class Flower(var flowerName: String){
        fun getName():String{
            return "this is $flowerName"
        }
    }

    //嵌套类加上inner关键字，就变成了内部类
    //只有声明内部类添加了inner关键字，才能访问外部成员
    inner class Frut(var fruitName:String){
        fun getName():String{
            return "this is $name grout $fruitName"
        }
    }
}
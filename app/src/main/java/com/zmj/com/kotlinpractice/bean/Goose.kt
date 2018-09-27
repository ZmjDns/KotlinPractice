package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 */
class Goose (name:String = "goose",sex:Int = Bird.MALE):Bird(name,sex),Behavior{
    override fun fly(): String {
        return "Goose can fly a little,but not far or heigh"
    }

    override fun swim(): String {
        return "Goose swim very well"
    }

    //接口已经实现了run（）方法，此处可以不用实现，当然也可以实现
    override fun run(): String {
        return super.run()
    }

    //重载接口抽象的属性
    override var skilledSports: String = "swim"

}
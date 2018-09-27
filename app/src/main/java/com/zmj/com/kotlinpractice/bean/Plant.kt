package com.zmj.com.kotlinpractice.bean

/**
 *Created by ZMJ
 *on 2018/9/4
 * Kotlin的数据类型，在class前增加关键字“data”，并声明入参完整的构造函数，即可实现如下功能：
 * 1.自动声明与构造入参同名的属性字段；（Kotlin类本身功能）
 * 2.自动实现每一个属性字段的get/set方法
 * 3.自动提供equals方法，用于比较两个数据对象是否相等
 * 4.自动提供copy方法，允许完整复制某个数据对象，也可在复制后单独修改某几个字段的值
 * 5.自动提供toString方法，用于打印数据对象中保存的所有字段值
 */
data class Plant(var name:String,var stem:String,var leaf:String,var flower:String,var fruit:String,var seed:String) {
}

//数据类要遵循的规则
//1.必须有构造函数，且至少输入一个参数
//2.主构造函数输入参数前面，必须添加关键字var/val，这是保证每一个入参都会自动声明同名属性字段
//数据类型有自己的一套行事规则，所以它只能是个独立的类，不能是其他类型的类，否则不同规则之间会爆发冲突
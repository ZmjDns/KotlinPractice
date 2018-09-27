package com.zmj.com.kotlinpractice.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.zmj.com.kotlinpractice.R
import com.zmj.com.kotlinpractice.bean.GoodMut
import kotlinx.android.synthetic.main.act_my_kotlin_continer.*

class MyKotlinContinerAct : AppCompatActivity() {

    var sortAsc :Boolean = true

    //只读集合
    //Set的创建可以使用标准库中的方法, 比如setOf()
    var goodsMutSet:Set<GoodMut> = setOf(GoodMut("华为",1200),GoodMut("小米",1000),GoodMut("中兴",1100))

    //可变集合
    //mutableSetOf()

    //只读队列List
    var goodsMutList :MutableList<GoodMut> = mutableListOf(GoodMut("华为",1200),GoodMut("小米",1000),GoodMut("中兴",1100))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_my_kotlin_continer)

        buttonClick()
    }

    //buttonClick fun
    fun buttonClick(){
        //Set
        btn_setReadOnly.setOnClickListener {
            //operateSetFor()
            //operateSetIterator()
            operateSetForEach()
        }
        //List
        btn_list.setOnClickListener {
            operateListSort()

        }
    }


    //operate fun
    /**
     * 1.Set集合不允许修改内部的值
     * 2.set集合无法删除指定的元素
     * 3.不能通过下标获取指定位置的元素
     */
    fun operateSetFor(){
        var desc = ""
        //使用for - in语句循环取出集合中的每一条数据
        for (item in goodsMutSet){
            desc = "${desc}名称：${item.name},价格：${item.price}\n"
        }
        tv_showContent.text = desc
    }

    fun operateSetIterator(){
        var descr = ""
        var iterator = goodsMutSet.iterator()
        while (iterator.hasNext()){
            var item = iterator.next()
            descr = "${descr} 名称：${item.name},价格：${item.price}\n"
        }
        tv_showContent.text = descr
    }
    fun operateSetForEach():TextView{
        var desc = ""
        //forEach内部使用it指代每一条记录
        goodsMutSet.forEach { desc = "${desc} 名称：${it.name},价格：${it.price}\n"}
        tv_showContent.text = desc
        return tv_showContent
    }
    /**
     *1.队列的get方法能够取得指定位置的元素
     * 2.MutableList的add方法每次都把元素添加到队列的末尾，也可以添加到指定位置
     * 3.MutableList的set方法允许替换和修改指定位置的元素
     * 4.MutableList的removeAt方法允许删除指定位置的元素
     * 5.MutableList提供了sort系列方法用于给队列中的元素重新排序，sortBy升序排列，sortByDescending按降序排列
     */
    fun operateListSort():TextView{
        goodsMutList.add(GoodMut("Apple",5000))
        if (sortAsc){
            goodsMutList.sortBy { it.price }
        }else{
            goodsMutList.sortByDescending { it.price }
        }
        var decs = ""
        for (item in goodsMutList){
            decs = "${decs} 价格：${item.price} 名称：${item.name}\n"
        }
        tv_showContent.text = decs
        sortAsc = !sortAsc
        return tv_showContent
    }

}

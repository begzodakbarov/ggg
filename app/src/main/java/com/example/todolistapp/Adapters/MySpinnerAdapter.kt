package com.example.todolistapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.todolistapp.R

class MySpinnerAdapter(val list : ArrayList<String>):BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView:View
        if (convertView==null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner,parent,false)
        }else{
            itemView = convertView
        }
        itemView.findViewById<TextView>(R.id.tv_item).text =list[position]
        return itemView
    }

}
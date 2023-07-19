package com.example.todolistapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.todolistapp.MyUtils.ToDoDeal
import com.example.todolistapp.R

class MyExpandableListAdapter(val map:HashMap<String, ArrayList<ToDoDeal>>, val titleList: List<String>):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titleList.size


    override fun getChildrenCount(groupPosition: Int): Int {
        val childList = map[titleList[groupPosition]]
        return childList?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): ToDoDeal{
        val childList = map[titleList[groupPosition]]!!
        return childList[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView:View
        if (convertView==null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_parent, parent, false)
        }else{
            itemView=convertView
        }
        itemView.findViewById<TextView>(R.id.tv_parent).text = titleList[groupPosition]
        return itemView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView:View
        if (convertView==null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        }else{
            itemView=convertView
        }

        itemView.findViewById<TextView>(R.id.tv_child).text = getChild(groupPosition, childPosition).name
        return itemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
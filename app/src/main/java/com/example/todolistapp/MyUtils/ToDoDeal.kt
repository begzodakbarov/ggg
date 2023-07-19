package com.example.todolistapp.MyUtils

import java.io.Serializable

data class ToDoDeal(var name:String, var description:String, var degree:String, var date:String, var deadline:String, var state:Int = 0)
    :Serializable
/*
0-open
1-development
2-uploading
3-reject
4-closed
 */
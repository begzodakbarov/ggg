package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolistapp.Adapters.MySpinnerAdapter
import com.example.todolistapp.MyUtils.Cache
import com.example.todolistapp.MyUtils.MySpinnerData
import com.example.todolistapp.MyUtils.ToDoDeal
import com.example.todolistapp.databinding.ActivityAddDealBinding

class AddDealActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddDealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddDealBinding.inflate(layoutInflater)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Add todo"

        binding.spinner.adapter = MySpinnerAdapter(MySpinnerData.list)
        Cache.init(this)

        binding.btnSave.setOnClickListener {
            binding.apply {
                var toDoDeal=ToDoDeal(edtName.text.toString(),edtDescription.text.toString(),edtDate.text.toString(),edtDeadline.text.toString(),spinner.selectedItem.toString())
                val list = Cache.obektString
                list.add(toDoDeal)
                Cache.obektString = list
                finish()
            }
        }
    }
}
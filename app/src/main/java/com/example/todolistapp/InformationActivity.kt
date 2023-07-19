package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolistapp.MyUtils.Cache
import com.example.todolistapp.MyUtils.ToDoDeal
import com.example.todolistapp.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInformationBinding
    private lateinit var toDoDeal : ToDoDeal
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInformationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Cache.init(this)
        toDoDeal = intent.getSerializableExtra("keyTodo") as ToDoDeal

        binding.apply {
            infoName.text = toDoDeal.name
            infoDate.text = toDoDeal.date
            infoDeadline.text = toDoDeal.deadline
            infoState.text = toDoDeal.degree

            when(toDoDeal.state){
                0-> rdOpen.isChecked = true
                1-> rdDvlp.isChecked = true
                2-> rdLoad.isChecked = true
                3-> rdReject.isChecked = true
                4-> rdClose.isChecked = true
            }
            val list = Cache.obektString
            val index = list.indexOf(toDoDeal)

            btnDo.setOnClickListener{
                val a =radioGr.checkedRadioButtonId
                when(a){
                    R.id.rd_open -> toDoDeal.state = 0
                    R.id.rd_dvlp -> toDoDeal.state = 1
                    R.id.rd_load -> toDoDeal.state = 2
                    R.id.rd_reject -> toDoDeal.state = 3
                    R.id.rd_close -> toDoDeal.state = 4
                }
                list[index] = toDoDeal
                Cache.obektString = list
                Toast.makeText(this@InformationActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
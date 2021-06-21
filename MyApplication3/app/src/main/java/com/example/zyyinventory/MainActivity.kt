package com.example.zyyinventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import com.example.zyyinventory.databinding.ActivityMainBinding
import com.example.zyyinventory.databinding.FragmentABinding

class MainActivity : AppCompatActivity() {
    private lateinit var  frbinding: FragmentABinding
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



//         binding.calendarView.setOnDateChangeListener{
//
//
//         }


    }
}
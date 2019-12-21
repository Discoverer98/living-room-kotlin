package com.discoverer.livingRoomKotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.discoverer.livingRoomKotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = MainViewModel(this)
    }


    class MainViewModel(private val context: Context) {

        fun enterLivingRoom(view: View) {
            val arguments = LivingRoomActivity.Arguments("blue", 4)
            arguments.startActivity(context)
        }

    } // MainViewModel class

} // MainActivity class

package com.discoverer.livingRoomKotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.discoverer.livingRoomKotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun enterLivingRoom() {
        val arguments = LivingRoomActivity.Arguments("blue", 4)
        arguments.startActivity(this)
    }

} // MainActivity class

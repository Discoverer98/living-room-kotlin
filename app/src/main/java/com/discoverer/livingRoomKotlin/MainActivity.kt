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

        fun enterLivingRoom(roomColor: String?, numOfRoomsStr: String?) {
            val arguments = LivingRoomActivity.Arguments(
                roomColor = roomColor ?: "", 
                numOfRooms = Integer.parseInt(numOfRoomsStr ?: "0"))
            arguments.startActivity(context)
        }

    } // MainViewModel class

} // MainActivity class

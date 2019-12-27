package com.discoverer.livingRoomKotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.discoverer.livingRoomKotlin.databinding.ActivityMainBinding

/**
 * Sample class to show the usage of the Activity Parameters idiom.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Thanks to MVVM and Data Binding, we don't need to resort to ButterKnife to get the data from the UI.
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = MainViewModel(this)
    }


    /**
     * A simple ViewModel class, which just responds to the "Enter Living Room" button click.
     */
    class MainViewModel(private val context: Context) {

        fun enterLivingRoom(roomColor: String?, numOfRoomsStr: String?) {
            // Even though there are only 2 Activity arguments being passed here, I'm using
            // named parameters to show how it can replace the Builder pattern that is used
            // with AutoValue when programming in Java.
            val arguments = LivingRoomActivity.Arguments(
                roomColor = roomColor ?: "",
                numOfRooms = Integer.parseInt(numOfRoomsStr ?: "0"))
            arguments.startActivity(context)
        }

    } // MainViewModel class

} // MainActivity class

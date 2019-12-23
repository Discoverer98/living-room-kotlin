package com.discoverer.livingRoomKotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.discoverer.livingRoomKotlin.databinding.ActivityLivingRoomBinding


class LivingRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLivingRoomBinding = DataBindingUtil.setContentView(this, R.layout.activity_living_room)
        binding.arguments = Arguments.createFromIntent(intent)
    }


    class Arguments(val roomColor: String, val numOfRooms: Int) {

        companion object {

            private const val ROOM_COLOR_TAG = "roomColorTag"
            private const val NUM_OF_WALLS_TAG = "numOfWallsTag"
            private const val DEFAULT_NUM_OF_WALLS = 4

            fun createFromIntent(intent: Intent): Arguments {
                return Arguments(intent.getStringExtra(ROOM_COLOR_TAG), intent.getIntExtra(
                    NUM_OF_WALLS_TAG, DEFAULT_NUM_OF_WALLS))
            }

        } // companion object

        fun startActivity(context: Context) {
            val intent = Intent(context, LivingRoomActivity::class.java)
            intent.putExtra(ROOM_COLOR_TAG, roomColor)
            intent.putExtra(NUM_OF_WALLS_TAG, numOfRooms)
            context.startActivity(intent)
        }

    } // Arguments class

} // LivingRoomActivity class

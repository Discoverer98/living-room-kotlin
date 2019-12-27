package com.discoverer.livingRoomKotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.discoverer.livingRoomKotlin.databinding.ActivityLivingRoomBinding

/**
 * Sample Activity class just to show how you can make use of the data passed through the
 * Activity Parameters idiom.
 */
class LivingRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLivingRoomBinding = DataBindingUtil.setContentView(this, R.layout.activity_living_room)
        binding.arguments = Arguments.createFromIntent(intent)
    }

    /**
     * The actual Arguments class, that will encapsulate the mechanism for passing data to an Activity.
     * Due to the modern features of Kotlin, we don't need to use an AutoValue.
     * This class can be used for other purposes, like passing this data to a Fragment by generating a
     * Bundle object with the data in it.
     */
    class Arguments(val roomColor: String, val numOfRooms: Int) {

        companion object {

            private const val ROOM_COLOR_TAG = "roomColorTag"
            private const val NUM_OF_WALLS_TAG = "numOfWallsTag"
            private const val DEFAULT_NUM_OF_WALLS = 4

            /**
             * Function to create an Arguments object from an Intent object.
             */
            fun createFromIntent(intent: Intent): Arguments {
                return Arguments(
                    roomColor = intent.getStringExtra(ROOM_COLOR_TAG),
                    numOfRooms = intent.getIntExtra(NUM_OF_WALLS_TAG, DEFAULT_NUM_OF_WALLS))
            }

        } // companion object

        /**
         * Function to start the Activity associated with this Arguments class, and that will put
         * the required data in an Intent object.
         */
        fun startActivity(context: Context) {
            val intent = Intent(context, LivingRoomActivity::class.java)
            intent.putExtra(ROOM_COLOR_TAG, roomColor)
            intent.putExtra(NUM_OF_WALLS_TAG, numOfRooms)
            context.startActivity(intent)
        }

    } // Arguments class

} // LivingRoomActivity class

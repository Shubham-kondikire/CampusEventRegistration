package com.techconnect.campusevent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.techconnect.campusevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: Home screen created")

        binding.btnRegisterNow.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Home screen visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Home screen in foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Home screen losing focus")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Home screen no longer visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Home screen restarting")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Home screen destroyed")
    }
}

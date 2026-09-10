package com.techconnect.campusevent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.techconnect.campusevent.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding
    private val TAG = "ConfirmationActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: Confirmation screen created")

        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val category = intent.getStringExtra("EXTRA_CATEGORY") ?: ""
        val certificate = intent.getBooleanExtra("EXTRA_CERTIFICATE", false)

        binding.tvConfirmationTitle.text = "Registration Confirmed!"
        binding.tvConfirmationDetails.text = buildString {
            append("Thank you, $name!\n\n")
            append("You have successfully registered for:\n")
            append("$category\n\n")
            if (certificate) {
                append("A participation certificate will be provided.")
            } else {
                append("No participation certificate requested.")
            }
        }

        binding.btnBackHome.setOnClickListener {
            finishAffinity()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Confirmation screen visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Confirmation screen in foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Confirmation screen losing focus")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Confirmation screen no longer visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Confirmation screen restarting")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Confirmation screen destroyed")
    }
}

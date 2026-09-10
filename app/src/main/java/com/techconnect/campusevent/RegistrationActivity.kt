package com.techconnect.campusevent

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.techconnect.campusevent.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private val TAG = "RegistrationActivity"
    private val CHANNEL_ID = "registration_channel"
    private val NOTIFICATION_ID = 101
    private val NOTIFICATION_PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: Registration screen created")

        createNotificationChannel()
        askNotificationPermission()

        binding.btnSubmit.setOnClickListener {
            submitRegistration()
        }
    }

    private fun submitRegistration() {
        val name = binding.etName.text.toString().trim()
        val usn = binding.etUsn.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()

        if (name.isEmpty() || usn.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val genderId = binding.rgGender.checkedRadioButtonId
        if (genderId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
            return
        }
        val gender = findViewById<RadioButton>(genderId).text.toString()

        val categoryId = binding.rgEventCategory.checkedRadioButtonId
        if (categoryId == -1) {
            Toast.makeText(this, "Please select an event category", Toast.LENGTH_SHORT).show()
            return
        }
        val category = findViewById<RadioButton>(categoryId).text.toString()

        if (!binding.cbAgree.isChecked) {
            Toast.makeText(this, "You must agree to the event rules", Toast.LENGTH_SHORT).show()
            return
        }

        val wantsCertificate = binding.tbCertificate.isChecked

        showRegistrationNotification(category)

        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("EXTRA_NAME", name)
            putExtra("EXTRA_USN", usn)
            putExtra("EXTRA_EMAIL", email)
            putExtra("EXTRA_GENDER", gender)
            putExtra("EXTRA_CATEGORY", category)
            putExtra("EXTRA_CERTIFICATE", wantsCertificate)
        }
        startActivity(intent)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Registration Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notifies when a registration is successful"
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_CODE
                )
            }
        }
    }

    private fun showRegistrationNotification(category: String) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Registration Successful")
            .setContentText("You are successfully registered for $category")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
            == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, builder.build())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Registration screen visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Registration screen in foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Registration screen losing focus")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Registration screen no longer visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Registration screen restarting")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Registration screen destroyed")
    }
}

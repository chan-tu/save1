package com.example.apppractice

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.apppractice.databinding.ActivityMainBinding
import java.util.Calendar
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val myNotificationID=1
    private val channelID="default"

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel(channelID,"default channel",
                NotificationManager.IMPORTANCE_DEFAULT)
            channel.description="description text of this channel"
            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}

package com.example.apppractice

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.apppractice.databinding.ActivityMainBinding
import java.util.Calendar
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

//    private val myNotificationID=1
//    private val channelID="default"
//
//    private fun createNotificaionChannel(){
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//            val channel=NotificationChannel(channelID,"defult channel",
//                NotificationManager.IMPORTANCE_DEFAULT)
//            channel.description="description text of this channel"
//            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.notificationButton.setOnClickListener {
            notification()
        }
    }

    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelName = "My channel"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "This is My channel"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                //안드로이드 기본 사운드
                setSound(uri, audioAttributes)
                enableVibration(true)
                //알림왔을 때의 진동
            }
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.happy)
        val intent = Intent(this, SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("뉴 알림")
            setContentText("알림 입니다")
            setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.")
            )
            setLargeIcon(bitmap)
            addAction(R.mipmap.ic_launcher, "Action", pendingIntent)
        }
        manager.notify(11, builder.build())

    }
}

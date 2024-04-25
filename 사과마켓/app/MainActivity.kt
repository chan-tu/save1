package com.example.apppractice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractice.databinding.ActivityMainBinding


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataList = mutableListOf<Item>()
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList.add(
            Item(R.drawable.electric_fan, "일주일전에 구입한 선풍기 입니다", "필요가 없어서 내놓습니다 필요하신분은 연락주세요", "가설자", 10000, "서울 강남구", 15, 10, false)
        )

        val adapter = SellAdapter(dataList)
        binding.recylcerView.adapter = adapter
        binding.recylcerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : SellAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, MainDetailActivity::class.java)
                intent.putExtra(Cost.ITEM_INDEX, position)
                intent.putExtra(Cost.ITEM_OBJECT, dataList[position])
                activityResultLauncher.launch(intent)
            }
        }
        adapter.itemLongClick = object : SellAdapter.ItemLongClick {
            override fun onLongClick(view: View, position: Int) {
                val ad = AlertDialog.Builder(this@MainActivity)
                ad.setIcon(R.drawable.chat)
                ad.setTitle("상품 삭제")
                ad.setMessage("상품을 삭제 하시겠습니까?")
                ad.setPositiveButton("확인") { _, _ ->
                    dataList.removeAt(position)
                    adapter.notifyItemRemoved(position)
                }
                ad.setNegativeButton("취소") { dialog, _ ->
                    dialog.dismiss()
                }
                ad.show()
            }
        }
        binding.notiImage.setOnClickListener {
            notification()
        }

        val fadeIn = AlphaAnimation(0f, 1f).apply { duration = 500 }
        val fadOut = AlphaAnimation(1f, 0f).apply { duration = 500 }
        var top = true

        binding.recylcerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.recylcerView.canScrollVertically(-1)
                    && newState == RecyclerView.SCROLL_STATE_IDLE
                ) {
                    binding.scroll.startAnimation(fadOut)
                    binding.scroll.visibility = View.GONE
                    top = true
                } else {
                    if (top) {
                        binding.scroll.visibility = View.VISIBLE
                        binding.scroll.startAnimation(fadeIn)
                        top = false
                    }
                }
            }
        })

        binding.scroll.setOnClickListener {
            binding.recylcerView.smoothScrollToPosition(0)
        }
        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val itemIND = it.data?.getIntExtra("itemIndex", 0) as Int
                    val islike = it.data?.getBooleanExtra("islike", false) as Boolean

                    if (islike) {
                        dataList[itemIND].like = true
                        dataList[itemIND].interestChat += 1
                    } else {
                        if (dataList[itemIND].like) {
                            dataList[itemIND].like = false
                            dataList[itemIND].interestChat -= 1
                        }
                    }
                    adapter.notifyItemChanged(itemIND)
                }
            }

    }



    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        val ud = AlertDialog.Builder(this)
        ud.setIcon(R.drawable.chat)
        ud.setTitle("종료")
        ud.setMessage("종료 하시겠습니까")
        ud.setPositiveButton("확인") { _, _ ->
            finish()
        }
        ud.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }
        ud.show()
    }

    private fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        val chID = "One-channel"
        val chName = "My Channel One"
        val ch = NotificationChannel(
            chID,
            chName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "My Channel One Description"
            setShowBadge(true)
            val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
            setSound(uri, audioAttributes)
            enableVibration(true)
        }
        manager.createNotificationChannel(ch)

        builder = NotificationCompat.Builder(this, chID)

        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("키워드 알림")
            setContentText("키워드 알림 도착")
        }
        manager.notify(11, builder.build())
    }
}

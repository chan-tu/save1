package com.example.apppractice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.apppractice.databinding.ActivityMainDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

@Suppress("DEPRECATION")
class MainDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainDetailBinding
    private var detailLike = false
    private val detailItem: Item? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Cost.ITEM_OBJECT, Item::class.java)
        } else {
            intent.getParcelableExtra(Cost.ITEM_OBJECT)
        }
    }
    private val positionItem: Int by lazy {
        intent.getIntExtra(Cost.ITEM_INDEX, 0)
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("jblee", "itemPostion=$positionItem")

        binding.itemImage.setImageDrawable(detailItem?.let {
            ResourcesCompat.getDrawable(
                resources,
                it.itemImage,
                null
            )
        })
        binding.sellerNameText.text = detailItem?.sellerName
        binding.sellerAddressText.text = detailItem?.sellerAddress
        binding.itemNameText.text = detailItem?.itemName
        binding.itemDetailText.text = detailItem?.itemDetail
        binding.itemPriceText.text = DecimalFormat("#,###").format(detailItem?.itemPrice) + "원"

        detailLike = detailItem?.like == true

        binding.likeImage.setImageResource(
            if (detailLike) {
                R.drawable.heart_two
            } else {
                R.drawable.heart_one
            }
        )
        binding.backImage.setOnClickListener {
            exit()
        }

        binding.detailLike.setOnClickListener {
            detailLike = if (!detailLike) {
                binding.likeImage.setImageResource(R.drawable.heart_two)
                Snackbar.make(binding.constLayout, "관심 목록에 추가", Snackbar.LENGTH_SHORT).show()
                true
            } else {
                binding.likeImage.setImageResource(R.drawable.heart_one)
                false
            }
        }

    }

    private fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("itemIndex", positionItem)
            putExtra("isLike", detailLike)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()

    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        exit()
    }
}

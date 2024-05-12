package com.example.myapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapp.data.DustItem
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.retrofit.NetWorkClient
import com.skydoves.powerspinner.IconSpinnerAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var items= mutableListOf<DustItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.spinnerViewGoo.setOnSpinnerItemSelectedListener<String>{_, _, _, text ->
            communicateNetWork(setUpDustParameter(text))
        }
        binding.spinnerViewGoo.setOnSpinnerItemSelectedListener<String>{_, _, _, text ->

            Log.d("miseya", "selectedItem: spinnerViewGoo selected >  $text")
            var selectedItem=items.filter { f -> f.stationName == text }
            Log.d("miseya", "selectedItem: sidoName > " + selectedItem[0].sidoName)
            Log.d("miseya", "selectedItem: pm10Value > " + selectedItem[0].pm10Value)

            binding.cityNameText.text=selectedItem[0].sidoName+" "+selectedItem[0].stationName
            binding.dateText.text=selectedItem[0].dataTime
            binding.unitText.text=selectedItem[0].pm10Value+" ㎍/㎥"

            when(getGrade(selectedItem[0].pm10Value)){
                1->{
                    binding.mainBg.setBackgroundColor(Color.parseColor("#9ED2EC"))
                    binding.faceImageView.setImageResource(R.drawable.img)
                    binding.emptyText.text="좋음"
                }
                2->{
                    binding.mainBg.setBackgroundColor(Color.parseColor("#D6A478"))
                    binding.faceImageView.setImageResource(R.drawable.img)
                    binding.emptyText.text="보통"
                }
                3->{
                    binding.mainBg.setBackgroundColor(Color.parseColor("#DF7766"))
                    binding.faceImageView.setImageResource(R.drawable.img)
                    binding.emptyText.text="나쁨"
                }
                4->{
                    binding.mainBg.setBackgroundColor(Color.parseColor("#BB3320"))
                    binding.faceImageView.setImageResource(R.drawable.img)
                    binding.emptyText.text="매우 나쁨"
                }
            }
        }
    }

    private fun communicateNetWork(param:HashMap<String,String>)=lifecycleScope.launch() {
        val responesDate= NetWorkClient.dustNetWork.getDust(param)
        Log.d("Parsing Dust ::", responesDate.toString())

        val adapter=IconSpinnerAdapter(binding.spinnerViewGoo)
        items=responesDate.response.dustBody.dustItem!!

        val goo=ArrayList<String>()
        items.forEach{
            Log.d("add Item : ", it.stationName)
            goo.add(it.stationName)
        }

        runOnUiThread{
            binding.spinnerViewGoo.setItems(goo)
        }
    }

    private fun setUpDustParameter(sido:String):HashMap<String,String>{
        val authKey=
            "YBZ(....)SVg1pEC39CVbmsA=="
        return hashMapOf(
            "serviceKey" to authKey,
            "returnType" to "json",
            "numOfRows" to "1",
            "sidoName" to sido,
            "ver" to "1.0"
        )
    }

    fun getGrade(value:String):Int{
        val mValue=value.toInt()
        var grade=1
        grade=if(mValue>=0&&mValue<=30){
            1
        }else if(mValue>=31&&mValue<=80){
            2
        }else if(mValue>=81&&mValue<=100){
            3
        }else 4
        return grade
    }
}

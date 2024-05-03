package com.example.apppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.apppractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentDataListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            frament1Button.setOnClickListener {
                // [1] Activity -> FirstFragment
                val dataToSend = "Hello First \n From Running Man"
                //dataToSend라는 String 데이터 생성
                val fragment = FirstFragement.newInstance(dataToSend)
                //FirstFragment에 newInstance만들어 dataToSend를 저장
                setFragment(fragment)
                //생성된fragment에 setFragment를 만들어 저장
                //newInstance에 dataToSend를 넣고 fragment를 생성하여 저장
            }
            frament2Button.setOnClickListener {
                // [1] Activity -> SecondFragment
                val dataToSend = "Hello Second \n From Running Man"
                val fragment = SecondFragement.newInstance(dataToSend)
                setFragment(fragment)
            }
        }
        setFragment(FirstFragement())
    }

    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack("")
        }
    }
    // [3] SecondFragment -> Activity
    override fun onDataReceived(data: String) {
        //Fragment에서 받은 데이터 처리
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }
}

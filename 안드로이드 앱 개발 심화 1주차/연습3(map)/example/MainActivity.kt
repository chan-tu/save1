package com.example.apppractice

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.apppractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object{
        private const val PERMISSION_REQUEST_ACCESS_FINE_LOCATION=100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        requestLocationPermission()
        //requestLocationPermission는 먼저 앱에 위치 권한이 있는지 확인

    }

    private fun requestLocationPermission(){
        if(ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        )!=PackageManager.PERMISSION_GRANTED
            ){
            ActivityCompat.requestPermissions(
                //권한이 없으면 ActivityCompat.requestPermissions메소들을 사용하여 권한 요청
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_ACCESS_FINE_LOCATION
            )
        }else{
            getLocation()
        }
    }

    override fun onRequestPermissionsResult(
        //결과는 onRequestPermissionsResult 콜백 메소드에서 처리
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_REQUEST_ACCESS_FINE_LOCATION->{
                if((grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                   getLocation()
                    // 사용자가 권한을 부여하면 getLocation 메소드를 호출하여 위치 정보를 사용
                }else{

                }
                return
            }
        }
    }
    private fun getLocation(){}
}

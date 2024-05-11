package com.example.myapp
//package com.android.ex11_googlemap

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapp.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnSuccessListener

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mGoogleMap: GoogleMap

    lateinit var fusedLocationClient: FusedLocationProviderClient

    lateinit var locationCallback: LocationCallback

    lateinit var locationPermission: ActivityResultLauncher<Array<String>>
    //OmMapCallback의 전역 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationPermission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) //Permission이 있는지 확인
        { result ->
            if (result.all { it.value }) {
                (supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment)!!.getMapAsync(this)
                //Permission을 가지고 있으면 mapView가 연결되어 실행되고 getMapAsync에 callback(this)를 연결하면 OnMapReadCallback의해 맵이 준비되면 onMapReady자동으로 콜백
            } else {
                Toast.makeText(this, "권한 승인 필요", Toast.LENGTH_LONG).show()
            }
        }
        //권한이 없을 경우 권한 요청
        locationPermission.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }

    override fun onMapReady(p0: GoogleMap) {

        val seoul = LatLng(37.566610, 126.978403)
        //marker 위치
        mGoogleMap = p0
        mGoogleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mGoogleMap.apply {
            val markerOptions = MarkerOptions()
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
            markerOptions.position(seoul)
            markerOptions.title("서울시청")
            markerOptions.snippet("Tel:01-123")
            addMarker(markerOptions)
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        //위치 정보를 받기위해 LocationService의 getFusedLcoationProviderClient를 받음
        updateLocation()
        //updateLocation 메소드를 호출
    }//OnMapReadyCallback이 추가되면 onMapReady가 필수적으로 추가

    fun updateLocation() {
        val locationRequset = LocationRequest.create().apply {
            interval = 1000
            fastestInterval = 500
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                //Callback는 초당 한번씩 로케이션 리조트가 들어옴
                locationResult?.let {
                    for (location in it.locations) {
                        Log.d("위치 정보", "위도:${location.latitude} 경도:${location.longitude}")
                        //1초에 한번씩 위치가 갱신 되면서 로그가 찍힘
                        setLastLocation(location)
                        //현재 위치가 갱신되면 setLastLocation이 location이 저장 되어 출력
                    }
                }
            }
        }
        //권한 처리 추가 부분
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.requestLocationUpdates(locationRequset, locationCallback,
            //requestLocationUpdates에 locationRequset와 locationCallback를 저장
            //저장을 하면 위치가 변경될때 마다 초당으로 한번씩 호출이 됨
            Looper.myLooper()!!
        )

    }
    //위치를 계속 받음

    fun setLastLocation(lastLocation: Location) {
        val LATLNG = LatLng(lastLocation.latitude, lastLocation.longitude)

        val markerOptions = MarkerOptions().position(LATLNG).title("여기 있습니다")
        //위치를 받고 title에 '여기 있다'는 marker를 올림
        val cameraPosition = CameraPosition.Builder().target(LATLNG).zoom(15.0f).build()
        mGoogleMap.addMarker(markerOptions)
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}

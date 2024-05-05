package com.example.apppractice

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        findViewById<Button>(R.id.dialog_Button).setOnClickListener {
            MyDialogFragment().show(supportFragmentManager, "My")
        }

        //기본 다이얼 로그
        binding.dialogButton.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 제목")
            builder.setMessage("기본 메세지")
            builder.setIcon(R.mipmap.ic_launcher)

            //버튼 클릭시의 작업
            val listener = object : DialogInterface.OnClickListener {
                //listener는 builder의 PositiveButton(확인 또는 Ok)를 의미
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            binding.titleText.text = "hi~"

                        DialogInterface.BUTTON_NEUTRAL ->
                            binding.titleText.text = "다이얼 리스트"

                        DialogInterface.BUTTON_NEGATIVE ->
                            binding.titleText.text = "다이얼 리스트"
                    }
                }
            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", listener)
            builder.setNeutralButton("닫기", listener)
            //Positive,Negative,Neutral 등 3개의 버튼을 눌렀을 떄 listener 호출

            builder.show()
        }
        //커스텀 다이얼 로그
        binding.customDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼")
            builder.setIcon(R.mipmap.ic_launcher)

            val v1 = layoutInflater.inflate(R.layout.dialog, null)
            //dialog레이아웃을 v1에 저장

            builder.setView(v1)
            //builder.setView를 지정하여 v1를 저장

            val lietener = DialogInterface.OnClickListener { p0, p1 ->
                val aler = p0 as AlertDialog
                val edit1: EditText? = aler.findViewById<EditText>(R.id.edit_Name_Text)
                val edit2: EditText? = aler.findViewById<EditText>(R.id.edit_Age_Text)

                binding.titleText.text = "이름 : ${edit1?.text}"
                binding.titleText.append(" / 나이 : ${edit2?.text}")
                //append는 text를 뒤에 붙인다는 의미
            }

            builder.setPositiveButton("확인", lietener)
            builder.setNegativeButton("취소", null)
            //취소는 lietener를 호출할 필요가 없기 때문에 null를 호출

            builder.show()
        }
        //날짜 다이얼 로그
        binding.dateDialogButton.setOnClickListener {
            val calender = Calendar.getInstance()
            //getInstance를 사용하면 오늘 날짜 자동 호출
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                binding.titleText.text = "${i}년 ${i2 + 1}월 ${i3}일"
                //listener를 사용하면 특정년도, 특정 월, 특정 일 출력이 가능
            }

            //오늘날짜
            var picker = DatePickerDialog(this, listener, year, month, day)
            //DatePickerDialog는 AlertDialog를 사용하지 않음
            picker.show()
        }

        //시간 다이얼 로그
        binding.timeDialogButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            //getInstance를 사용하면 현재 시간 자동 호출
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                binding.titleText.text = "${i}시 ${i2}분"
                //listener를 사용하면 특정 시간 출력이 가능
            }

            val picker = TimePickerDialog(this, listener, hour, minute, false)
            picker.show()
        }

        //프로그레스 다이얼 로그
        binding.progressDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("프로그래스바")
            builder.setIcon(R.mipmap.ic_launcher)

            val v1 = layoutInflater.inflate(R.layout.progressbar, null)
            builder.setView(v1)

            builder.show()
            //로딩을 끝내는 코드는 디스미스
        }

    }
}

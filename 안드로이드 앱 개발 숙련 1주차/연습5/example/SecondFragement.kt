package com.example.apppractice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apppractice.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragement.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragement : Fragment() {
    // TODO: Rename and change types of parameters
    // [3] SecondFragment -> Activity
    private var listener: FragmentDataListener? = null
    //FragmentDataListener타임의 listener를 생성
    private var param1: String? = null
    private var param2: String? = null
    private var bindingg: FragmentSecondBinding? = null
    private val binding get() = bindingg!!

    override fun onAttach(context: Context) {
        //cotext:MainActivity와 SecondFragment를 서로 연결할 때 사용
        super.onAttach(context)
        // [3] SecondFragment -> Activity
        if (context is FragmentDataListener) {
            //context는 MainActivity에서 들어옴
            listener = context
            //listener에 context를 저장
        } else {
            throw RuntimeException("$context must implement FragmentDataListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        bindingg = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // [2] Fragment -> Fragment
        binding.secondFragmentText.text = param1
        // [3] Fragment -> Fragment
        binding.secondFragmentButton.setOnClickListener {
            val dataToSend = "Hello from SecondFragment!"
            listener?.onDataReceived(dataToSend)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragement.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            // [1] Activity -> FirstFragment
            SecondFragement().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Binding 객체 해제
        bindingg = null
        listener = null
    }

}

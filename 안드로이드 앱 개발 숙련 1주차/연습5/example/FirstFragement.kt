package com.example.apppractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apppractice.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
//const로 ARG_PARAM이라는 "param를 보유

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragement.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragement : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //param이라는 변수 생성
    private val binding by lazy { FragmentFirstBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            //let를 사용하는 이유는 arguments가 getmString를 어릴 수 있기 때문
            //arguments가 널이 아닐 때만 'param1 = it.getString(ARG_PARAM1)'에 저장
        }
    } 

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // [1] Activity -> FirstFragment
        binding.firstFragmentText.text = param1
        // [2] Fragment -> Fragment
        binding.firstFragmentButton.setOnClickListener {
            val dataToSend = "Hello Fragment2 \n From Running Man"
            val fragement2 = SecondFragement.newInstance(dataToSend)

            //Fragment에서 Fragment를 교체할때 사용하는 코드
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragement2)
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragement.
         */
        // TODO: Rename and change types and number of parameters
        //companion object로 newInstance를 생성
        @JvmStatic
        fun newInstance(param1: String) =
            FirstFragement().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    //putString로 ARG_PARAM("param1")에 들어오는 param값 저장
                }
            }

    }

}

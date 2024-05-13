package com.example.myapp.feature.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapp.Constants
import com.example.myapp.data.model.ImageModel
import com.example.myapp.databinding.FragmentSearchBinding
import com.example.myapp.data.retrofit_client.apiService
import com.example.myapp.model.SearchltemModel
import com.example.myapp.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var mContext: Context
    private lateinit var adapter: SearchAdapter
    private lateinit var gridmanager: StaggeredGridLayoutManager

    private var resItem: ArrayList<SearchltemModel> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        setupViews()
        setupListeners()
        return binding.root
    }

    private fun setupViews() {
        gridmanager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.searchResult.layoutManager=gridmanager
        adapter= SearchAdapter(mContext)
        binding.searchResult.adapter=adapter
        binding.searchResult.itemAnimator=null
        val lastSearch = Utils.getLastSearch(requireContext())
        binding.searchEdit.setText(lastSearch)
    }

    private fun setupListeners() {
        val imm=requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        binding.searchText.setOnClickListener {
            val query=binding.searchEdit.text.toString()
            if(query.isNotBlank()){
                Utils.saveLastSearch(requireContext(),query)
                adapter.clearItem()
                fetchImageResults(query)
            }else{
                Toast.makeText(mContext,"검색어 입력",Toast.LENGTH_SHORT).show()
            }
            imm.hideSoftInputFromWindow(binding.searchEdit.windowToken,0)
        }
    }

    private fun fetchImageResults(query:String){
        apiService.image_search(Constants.AUTH_HEADER,query,"recency",1,80)
            ?.enqueue(object :Callback<ImageModel?> {
                override fun onResponse(call: Call<ImageModel?>, response: Response<ImageModel?>) {
                    response.body()?.meta?.let { meta ->
                        if (meta.totalCount > 0) {
                            response.body()!!.documents.forEach { documents ->
                                val title = documents.displaySitename
                                val datatime = documents.dateTime
                                val uri = documents.thumbnailUrl
                                resItem.add(SearchltemModel(title, datatime, uri))
                            }
                        }
                    }
                    adapter.items = resItem
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<ImageModel?>, t: Throwable) {
                    Log.e("#jblee", "onFailure: ${t.message}")
                }
            })
    }
}

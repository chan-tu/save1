package com.example.myapp.feature.bookmark

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapp.MainActivity
import com.example.myapp.databinding.FragmentBookmarkBinding
import com.example.myapp.model.SearchltemModel

class BookmarkFragment : Fragment(){
    private lateinit var mContext:Context
    private var binding:FragmentBookmarkBinding?=null
    private lateinit var adapter: BookmarkAdapter

    private var likedItems:List<SearchltemModel> = listOf()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    override fun onCreateView(
        inflater:LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
    ):View?{
        val mainActivity=activity as MainActivity
        likedItems=mainActivity.itemLiked

        Log.d("BookmarkFragment", "#jblee likedItems size = ${likedItems.size}")

        adapter=BookmarkAdapter(mContext).apply {
            items=likedItems.toMutableList()
        }

        binding= FragmentBookmarkBinding.inflate(inflater,container,false).apply {
            bookmark.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            bookmark.adapter=adapter
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}

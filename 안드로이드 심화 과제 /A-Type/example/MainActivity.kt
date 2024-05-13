package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.feature.bookmark.BookmarkFragment
import com.example.myapp.feature.search.SearchFragment
import com.example.myapp.model.SearchltemModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    var itemLiked: ArrayList<SearchltemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            searchButton.setOnClickListener {
                setFragment(SearchFragment())
            }
            bookmarkButton.setOnClickListener {
                setFragment(BookmarkFragment())
            }
        }
        setFragment(SearchFragment())

    }

    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frame, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }


    fun addLikedItem(item: SearchltemModel){
        if(!itemLiked.contains(item)){
            itemLiked.add(item)
        }
    }

    fun removeLikedItem(item: SearchltemModel){
        itemLiked.remove(item)
    }
}

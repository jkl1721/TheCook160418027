package com.ubaya.thecook160418027.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.ViewModel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_myrecipe.*

class MyRecipeFragment : Fragment() {
    private lateinit var viewModel1: SearchViewModel
    private val searchListAdapter = MyRecipeAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myrecipe, container, false)
    }
    fun observeViewModel() {
        viewModel1.recipesLD.observe(viewLifecycleOwner, Observer {
            searchListAdapter.updateFeaturedList(it)
        })
        viewModel1.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recMyRecipes.visibility = View.GONE
                progressBarMy.visibility = View.VISIBLE
            } else {
                recMyRecipes.visibility = View.VISIBLE
                progressBarMy.visibility = View.GONE
            }
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel1 = ViewModelProvider(this).get(SearchViewModel::class.java)
        viewModel1.refresh()
        recMyRecipes.layoutManager = LinearLayoutManager(context)
        recMyRecipes.adapter = searchListAdapter
        observeViewModel()
    }
}
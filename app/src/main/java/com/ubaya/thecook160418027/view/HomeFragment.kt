package com.ubaya.thecook160418027.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.viewModel.FeaturedViewModel
import com.ubaya.thecook160418027.viewModel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var viewModel1: FeaturedViewModel
    private lateinit var viewModel2: RecipeViewModel
    private val featuredListAdapter = HomeFeaturedAdapter(arrayListOf())
    private val recipeListAdapter = HomeRecipeAdapter(arrayListOf())
    fun observeViewModel() {
        viewModel1.recipesLD.observe(viewLifecycleOwner, Observer {
            featuredListAdapter.updateFeaturedList(it)
        })
        viewModel1.recipesLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtError1.visibility = View.VISIBLE
            } else {
                txtError1.visibility = View.GONE
            }
        })
        viewModel1.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recFeatured.visibility = View.GONE
                progressBarHome1.visibility = View.VISIBLE
            } else {
                recFeatured.visibility = View.VISIBLE
                progressBarHome1.visibility = View.GONE
            }
        })
        viewModel2.recipesLD.observe(viewLifecycleOwner, Observer {
            recipeListAdapter.updateFeaturedList(it)
        })
        viewModel2.recipesLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtError2.visibility = View.VISIBLE
            } else {
                txtError2.visibility = View.GONE
            }
        })
        viewModel2.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recRecipes.visibility = View.GONE
                progressBarHome2.visibility = View.VISIBLE
            } else {
                recRecipes.visibility = View.VISIBLE
                progressBarHome2.visibility = View.GONE
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel1 = ViewModelProvider(this).get(FeaturedViewModel::class.java)
        viewModel1.refresh()
        viewModel2 = ViewModelProvider(this).get(RecipeViewModel::class.java)
        viewModel2.refresh()
        recFeatured.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recFeatured.adapter = featuredListAdapter
        recRecipes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recRecipes.adapter = recipeListAdapter
        recRecipes.isNestedScrollingEnabled = false
        observeViewModel()
    }
}
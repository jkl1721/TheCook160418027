package com.ubaya.thecook160418027.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {
    private lateinit var viewModel1: SearchViewModel
    private val searchListAdapter = SearchAdapter(arrayListOf())
    fun observeViewModel() {
        viewModel1.recipesLD.observe(viewLifecycleOwner, Observer {
            searchListAdapter.updateFeaturedList(it)
        })
        viewModel1.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recSearch.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            } else {
                recSearch.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel1 = ViewModelProvider(this).get(SearchViewModel::class.java)
        viewModel1.refresh()
        recSearch.layoutManager = LinearLayoutManager(context)
        recSearch.adapter = searchListAdapter
        observeViewModel()
        txtSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel1.refresh("%"+s+"%")
                recSearch.layoutManager = LinearLayoutManager(context)
                recSearch.adapter = searchListAdapter
                observeViewModel()
            }
        })
    }
}
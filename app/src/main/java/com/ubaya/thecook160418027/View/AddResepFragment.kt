package com.ubaya.thecook160418027.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.ViewModel.FeaturedViewModel
import com.ubaya.thecook160418027.ViewModel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_resep.*
import kotlinx.android.synthetic.main.fragment_home.*

class AddResepFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_resep, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSubmit.setOnClickListener {
            Snackbar.make(view, "Resep submitted and await for moderations.", Snackbar.LENGTH_LONG).show()
        }
    }
}
package com.ubaya.thecook160418027.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.model.Resep
import com.ubaya.thecook160418027.viewModel.DetailResepViewModel
import kotlinx.android.synthetic.main.fragment_add_resep.*

class AddResepFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_resep, container, false)
    }
    private lateinit var viewModel: DetailResepViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailResepViewModel::class.java)
        btnSubmit.setOnClickListener {
            if(txtNama.text.toString().trim().isEmpty() || txtBahan.text.toString().trim().isEmpty() ||
                txtLangkah.text.toString().trim().isEmpty() || txtUrl.text.toString().trim().isEmpty()){
                Snackbar.make(
                    view,
                    "Invalid Empty String! Fill The Empty Fields!",
                    Snackbar.LENGTH_LONG
                ).show()
            }else {
                var resep = Resep(
                    txtNama.text.toString(),
                    txtBahan.text.toString(), txtLangkah.text.toString(), txtUrl.text.toString(), 1
                )
                val list = listOf(resep)
                viewModel.addTodo(list)
                Snackbar.make(
                    view,
                    "Resep submitted and await for moderations.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}
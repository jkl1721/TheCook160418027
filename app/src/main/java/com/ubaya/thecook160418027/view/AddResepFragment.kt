package com.ubaya.thecook160418027.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.databinding.FragmentAddResepBinding
import com.ubaya.thecook160418027.model.Resep
import com.ubaya.thecook160418027.viewModel.DetailResepViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_add_resep.*
import java.util.concurrent.TimeUnit

class AddResepFragment : DialogFragment(),AddResepListener {
    private lateinit var databinding: FragmentAddResepBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate<FragmentAddResepBinding>(inflater, R.layout.fragment_add_resep, container, false)
        return databinding.root
    }
    private lateinit var viewModel: DetailResepViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailResepViewModel::class.java)
        databinding.addlistener = this
        databinding.resep = Resep("","","","")
    }

    override fun onAddResepClick(v: View, r:Resep) {
            if(r.name.toString().trim().isEmpty() || r.bahan.toString().trim().isEmpty() ||
                r.langkah.toString().trim().isEmpty() || r.imgUrl.toString().trim().isEmpty()){
                Snackbar.make(
                    v,
                    "Invalid Empty String! Fill The Empty Fields!",
                    Snackbar.LENGTH_LONG
                ).show()
            }else {
                val list = listOf(r)
                viewModel.addTodo(list)
                Snackbar.make(
                    v,
                    "Resep submitted and await for moderations.",
                    Snackbar.LENGTH_LONG
                ).show()
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        MainActivity.showNotification("Recipes Approved!",
                            "Your Recipes Has Been Delivered To System.",
                            R.drawable.ic_baseline_article_24)
                    }
                Navigation.findNavController(v).popBackStack()
        }
    }
}
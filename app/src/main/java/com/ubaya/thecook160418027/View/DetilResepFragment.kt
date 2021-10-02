package com.ubaya.thecook160418027.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.Util.loadImage
import com.ubaya.thecook160418027.ViewModel.DetailResepViewModel
import kotlinx.android.synthetic.main.fragment_detil_resep.*

class DetilResepFragment : Fragment() {
    private lateinit var viewModel: DetailResepViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detil_resep, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailResepViewModel::class.java)
        viewModel.fetch(DetilResepFragmentArgs.fromBundle(requireArguments()).id,DetilResepFragmentArgs.fromBundle(requireArguments()).name,DetilResepFragmentArgs.fromBundle(requireArguments()).bahan,
            DetilResepFragmentArgs.fromBundle(requireArguments()).langkah,DetilResepFragmentArgs.fromBundle(requireArguments()).imgUrl)
        observer()
    }
    fun observer(){
        viewModel.resepLD.observe(viewLifecycleOwner, Observer {
            txtNama.setText(viewModel.resepLD.value?.name)
            txtBahan.setText(viewModel.resepLD.value?.bahan)
            txtLangkah.setText(viewModel.resepLD.value?.langkah)
            imgResep.loadImage(viewModel.resepLD.value?.imgUrl, progressBarDetil)
        })
    }
}
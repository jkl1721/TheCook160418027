package com.ubaya.thecook160418027.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.ubaya.thecook160418027.R
import kotlinx.android.synthetic.main.fragment_setting.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.ubaya.thecook160418027.databinding.FragmentDetilResepBinding
import com.ubaya.thecook160418027.databinding.FragmentSearchBinding
import com.ubaya.thecook160418027.databinding.FragmentSettingBinding
import com.ubaya.thecook160418027.model.Resep


class SettingFragment : Fragment(),DarkChecked {
    private lateinit var databinding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate<FragmentSettingBinding>(inflater, R.layout.fragment_setting, container, false)
        return databinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            databinding.isCek = true
        }else{
            databinding.isCek = false
        }
        databinding.darkCheck = this
//        switchDark.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            }
//        }
    }

    override fun onCheckChanged(cb: CompoundButton, isChecked: Boolean) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
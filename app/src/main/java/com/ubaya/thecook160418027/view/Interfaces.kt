package com.ubaya.thecook160418027.view

import android.text.TextWatcher
import android.view.View
import android.widget.CompoundButton
import com.ubaya.thecook160418027.model.Resep

interface DarkChecked {
    fun onCheckChanged(cb: CompoundButton,
                       isChecked:Boolean
    )
}
interface AddListener {
    fun onAddClick(v: View)
}
interface AddResepListener {
    fun onAddResepClick(v: View, r:Resep)
}
interface CardClick {
    fun onCardClick(v:View, id:Int)
}

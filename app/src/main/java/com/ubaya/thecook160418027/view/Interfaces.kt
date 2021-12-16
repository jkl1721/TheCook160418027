package com.ubaya.thecook160418027.view

import android.view.View
import android.widget.CompoundButton
import com.ubaya.thecook160418027.model.Resep

interface TodoCheckedChangeListener {
    fun onCheckChanged(cb: CompoundButton,
                       isChecked:Boolean,
                       obj: Resep
    )
}
interface AddListener {
    fun onAddClick(v: View)
}
interface CardClick {
    fun onCardClick(v:View, id:Int)
}
interface TodoSaveChangesClick {
    fun onTodoSaveChangesClick(v: View, obj: Resep)
}
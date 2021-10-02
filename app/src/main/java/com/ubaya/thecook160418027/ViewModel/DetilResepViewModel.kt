package com.ubaya.thecook160418027.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.thecook160418027.Model.Resep

class DetailResepViewModel: ViewModel() {
    val resepLD = MutableLiveData<Resep>()
    fun fetch(id:String?,name:String?,bahan:String?,langkah:String?,imgUrl:String?) {
        val resep = Resep(id,name,bahan,langkah,imgUrl)
        resepLD.value = resep
    }
}
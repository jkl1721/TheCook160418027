package com.ubaya.thecook160418027.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.thecook160418027.Model.Resep

class FeaturedViewModel(application: Application): AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue?= null
    val recipesLD = MutableLiveData<List<Resep>>()
    val recipesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh() {
        loadingLD.value = true
        recipesLoadErrorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.1.128/ANMP/TheCook/featured.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                loadingLD.value = false
                val sType = object : TypeToken<List<Resep>>() { }.type
                val result = Gson().fromJson<List<Resep>>(response, sType)
                recipesLD.value = result
                loadingLD.value = false
            },
            {
                recipesLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
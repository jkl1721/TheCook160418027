package com.ubaya.thecook160418027.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.thecook160418027.model.Resep
import com.ubaya.thecook160418027.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class SearchViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val TAG = "volleyTag"
    private val job = Job()
    private var queue: RequestQueue?= null
    val recipesLD = MutableLiveData<List<Resep>>()
    val recipesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh(text:String="%%") {
        launch {
            val db = buildDb(getApplication())
            loadingLD.value = false
            val result = db.todoDao().selectResepWhere(text)
            recipesLD.value = result
            loadingLD.value = false
            recipesLoadErrorLD.value = false
        }
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}
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

class RecipeViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val TAG = "volleyTag"
    private val job = Job()
    private var queue: RequestQueue?= null
    val recipesLD = MutableLiveData<List<Resep>>()
    val recipesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh() {
        // -- Insert Internal Database Initial Data --
//        loadingLD.value = true
//        recipesLoadErrorLD.value = false
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "http://192.168.1.129/ANMP/TheCook/recipes.php"
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            { response ->
//                loadingLD.value = false
//                val sType = object : TypeToken<List<Resep>>() { }.type
//                val result = Gson().fromJson<List<Resep>>(response, sType)
//                result.forEach {
//                    launch {
//                        val db = buildDb(getApplication())
//                        db.todoDao().insertAll(it)
//                    }
//                }
//                recipesLD.value = result
//                loadingLD.value = false
//            },
//            {
//                recipesLoadErrorLD.value = true
//                loadingLD.value = false
//            })
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)
        launch {
            val db = buildDb(getApplication())
            val result = db.todoDao().selectAllResep()
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
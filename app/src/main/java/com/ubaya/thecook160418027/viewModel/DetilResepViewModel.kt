package com.ubaya.thecook160418027.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.thecook160418027.model.Resep
import com.ubaya.thecook160418027.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailResepViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val resepLD = MutableLiveData<Resep>()
    fun fetch(idd:Int) {
        val db = buildDb(getApplication())
        launch {
            resepLD.value =  db.todoDao().selectResep(idd)
        }
    }
    fun addTodo(list: List<Resep>) {
        launch {
            val db = buildDb(getApplication())
            db.todoDao().insertAll(*list.toTypedArray())
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}
package com.ubaya.thecook160418027.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.thecook160418027.model.Resep
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.util.loadImage
import kotlinx.android.synthetic.main.card_home2.view.*

class SearchAdapter(val resepList:ArrayList<Resep>): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){
    class SearchViewHolder(var view: View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_home2, parent, false)
        return SearchViewHolder(view)
    }
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.view.txtNama.text = resepList[position].name
        holder.view.cardResep2.setOnClickListener {
            val action = resepList[position].id?.let { it1 ->
                SearchFragmentDirections.actToDetil(it1.toString(),resepList[position].name,resepList[position].bahan,resepList[position].langkah,resepList[position].imgUrl)
            }
            if (action != null) {
                Navigation.findNavController(it).navigate(action)
            }
        }
        holder.view.imgResep.loadImage(resepList[position].imgUrl,
            holder.view.progressBarCard)
    }
    override fun getItemCount(): Int {
        return resepList.size
    }
    fun updateFeaturedList(newresepList: List<Resep>) {
        resepList.clear()
        resepList.addAll(newresepList)
        notifyDataSetChanged()
    }
}
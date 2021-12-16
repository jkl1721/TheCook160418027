package com.ubaya.thecook160418027.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.thecook160418027.R
import com.ubaya.thecook160418027.databinding.CardHomeBinding
import kotlinx.android.synthetic.main.card_home.view.*
import com.ubaya.thecook160418027.model.Resep
import com.ubaya.thecook160418027.util.loadImage

class HomeFeaturedAdapter(val resepList:ArrayList<Resep>):RecyclerView.Adapter<HomeFeaturedAdapter.FeaturedViewHolder>(),CardClick{
    class FeaturedViewHolder(var view: CardHomeBinding) : RecyclerView.ViewHolder(view.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FeaturedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<CardHomeBinding>(inflater, R.layout.card_home, parent, false)
        return FeaturedViewHolder(view)
    }
    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        holder.view.cardClick = this
        holder.view.resep = resepList[position]
    }
    override fun getItemCount(): Int {
        return resepList.size
    }
    fun updateFeaturedList(newresepList: List<Resep>) {
        resepList.clear()
        resepList.addAll(newresepList)
        notifyDataSetChanged()
    }

    override fun onCardClick(v: View, id: Int) {
        val action = HomeFragmentDirections.actToDetil(v.tag.toString(),"","","","")
        Navigation.findNavController(v).navigate(action)
    }
}
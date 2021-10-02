package com.ubaya.thecook160418027.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.thecook160418027.R
import kotlinx.android.synthetic.main.card_home.view.*
import com.ubaya.thecook160418027.Model.Resep
import com.ubaya.thecook160418027.Util.loadImage

class HomeFeaturedAdapter(val resepList:ArrayList<Resep>):RecyclerView.Adapter<HomeFeaturedAdapter.FeaturedViewHolder>(){
    class FeaturedViewHolder(var view: View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FeaturedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_home, parent, false)
        return FeaturedViewHolder(view)
    }
    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        holder.view.txtNama.text = resepList[position].name
        holder.view.cardResep1.setOnClickListener {
//            val action = resepList[position].id?.let { it1 ->
//                StudentListFragmentDirections.actionStudentDetail(
//                    it1,resepList[position].name,resepList[position].bahan,resepList[position].langkah,resepList[position].imgUrl)
//            }
//            if (action != null) {
//                Navigation.findNavController(it).navigate(action)
//            }
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
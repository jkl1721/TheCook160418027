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

class HomeRecipeAdapter(val resepList:ArrayList<Resep>):RecyclerView.Adapter<HomeRecipeAdapter.RecipeViewHolder>(){
    class RecipeViewHolder(var view: View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_home, parent, false)
        return RecipeViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
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
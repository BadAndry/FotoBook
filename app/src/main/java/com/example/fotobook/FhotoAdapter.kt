package com.example.fotobook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fotobook.databinding.FotoItemBinding

class FhotoAdapter(private val listenerClick: ListenerClick): RecyclerView.Adapter<FhotoAdapter.FotoHolder>() {
    val fhotoList = arrayListOf<Fhoto>()
    class FotoHolder(item: View): RecyclerView.ViewHolder(item) {

        val fhotoBinding = FotoItemBinding.bind(item)
        fun binding(fhoto: Fhoto, listenerClick: ListenerClick){
            fhotoBinding.im.setImageResource(fhoto.imageId)
            fhotoBinding.tvTittle.text = fhoto.tittle
            itemView.setOnClickListener {
                listenerClick.onClick(fhoto)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.foto_item, parent, false)
        return FotoHolder(view)
    }

    override fun onBindViewHolder(holder: FotoHolder, position: Int) {
        holder.binding(fhotoList[position], listenerClick)
    }

    override fun getItemCount(): Int {
        return fhotoList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addFoto(fhoto: Fhoto){
        fhotoList.addAll(listOf(fhoto))
        notifyDataSetChanged()
    }

}
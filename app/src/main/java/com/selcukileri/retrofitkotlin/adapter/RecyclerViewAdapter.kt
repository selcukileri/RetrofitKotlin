package com.selcukileri.retrofitkotlin.adapter

import android.graphics.Color
import android.inputmethodservice.Keyboard.Row
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selcukileri.retrofitkotlin.databinding.RecyclerRowBinding
import com.selcukileri.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList: ArrayList<CryptoModel>, val listener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    private val colors: Array<String> = arrayOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")
    interface Listener{
        fun onItemClicked(cryptoModel: CryptoModel)
    }

    class RowHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cryptoModel: CryptoModel, colors: Array<String>,position: Int, listener: Listener){
            binding.root.setOnClickListener {
                listener.onItemClicked(cryptoModel)
            }
            binding.root.setBackgroundColor(Color.parseColor(colors[position % 8]))
            binding.textName.text = cryptoModel.currency
            binding.textPrice.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position, listener)
    }
}
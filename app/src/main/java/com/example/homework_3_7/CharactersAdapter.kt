package com.example.homework_3_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3_7.databinding.ItemCharacterBinding

class CharactersAdapter(
    val characterList: ArrayList<Character>,
    val onClick:(position: Int) -> Unit

): RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>()  {

    inner class CharactersViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){

            val character = characterList[adapterPosition]
            binding.name.text = character.name
            binding.status.text = character.status
            binding.image.loadImage(character.image)
            binding.image.setOnClickListener(){
                onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = characterList.size

}
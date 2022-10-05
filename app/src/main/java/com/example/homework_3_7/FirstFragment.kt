package com.example.homework_3_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.homework_3_7.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    private val characterList = arrayListOf<Character>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharactersAdapter(characterList,this::onClick)
        binding.resyclerView.adapter = adapter
        loadData()

    }

    private fun loadData() {
        characterList.add(Character("Rick Sanchez","Alive","https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest/top-crop/width/360/height/360?cb=20160923150728"))
        characterList.add(Character("Morty Smith","Alive","https://static.wikia.nocookie.net/rickandmorty/images/e/ee/Morty501.png/revision/latest?cb=20210827150137"))
        characterList.add(Character("Albert Einstein","Dead","https://static.wikia.nocookie.net/rickandmorty/images/b/bc/Albert_Einstein.png/revision/latest?cb=20150730213810"))
        characterList.add(Character("Jerry Smith","Alive","https://static.wikia.nocookie.net/rickandmorty/images/f/f1/Jerry_Smith.png/revision/latest?cb=20160923151111"))
    }

    private fun onClick(position: Int){
        val character = characterList[position]
        val bundle = Bundle()
        bundle.putSerializable("character",character)

        findNavController().navigate(R.id.secondFragment,bundle)
    }
}
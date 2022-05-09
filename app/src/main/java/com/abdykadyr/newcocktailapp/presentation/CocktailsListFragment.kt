package com.abdykadyr.newcocktailapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abdykadyr.newcocktailapp.R
import com.abdykadyr.newcocktailapp.databinding.FragmentCocktailsListBinding
import java.lang.RuntimeException


class CocktailsListFragment : Fragment() {

    private var _binding: FragmentCocktailsListBinding? = null
    val binding: FragmentCocktailsListBinding
        get() = _binding ?: throw RuntimeException("FragmentCocktailsListBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailsListBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

    }
}
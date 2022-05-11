package com.abdykadyr.newcocktailapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abdykadyr.newcocktailapp.R
import com.abdykadyr.newcocktailapp.databinding.FragmentWelcomeScreenBinding
import java.lang.RuntimeException

class WelcomeScreenFragment : Fragment() {

    private lateinit var viewModel: WelcomeScreenViewModel

    private var _binding: FragmentWelcomeScreenBinding? = null
    val binding: FragmentWelcomeScreenBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeScreenBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WelcomeScreenAdapter()
        binding.rvFiltersList.adapter = adapter
        viewModel = ViewModelProvider(this)[WelcomeScreenViewModel::class.java]
        viewModel.listOfFilters.observe(viewLifecycleOwner) {
            adapter.listOfFilters = it
            CocktailsListFragment.newInstance()
        }
        binding.cvCategory.setOnClickListener { viewModel.getListOfCategoryFilters() }
        binding.cvAlcoholic.setOnClickListener { viewModel.getListOfAlcoholicFilters() }
        binding.cvIngredient.setOnClickListener { viewModel.getListOfIngredientFilters() }
        adapter.onFilterItemClickListener = {
            viewModel.search(it)
        launchCocktailsListFragment()}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //TODO: replace with Navigation
    private fun launchCocktailsListFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,CocktailsListFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    companion object {

    }
}

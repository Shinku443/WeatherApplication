package com.example.weatherapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.FragmentDisplayCitiesOverviewBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentCityOverview : Fragment() {

    private var _binding: FragmentDisplayCitiesOverviewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDisplayCitiesOverviewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listOfCities.setOnClickListener {
            //pass in selected data
            findNavController().navigate(R.id.action_FragmentDisplayCityOverview_to_FragmentSelectedCity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.weatherapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.FragmentDisplayCitiesOverviewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CityOverviewFragment : Fragment() {

    private var _binding: FragmentDisplayCitiesOverviewBinding? = null

    private val viewModel by activityViewModels<CityOverviewViewModel>()

    //var latText = EditText(requireContext())
    // var longText = EditText(requireContext())
    private var lat = 44
    private var lon = -44

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDisplayCitiesOverviewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.addButton.setOnClickListener {
            val inputTest = EditText(context)
            val addNewFragmentDialog = AddNewFragmentDialog()
            addNewFragmentDialog.setStyle(DialogFragment.STYLE_NORMAL, 0)
            addNewFragmentDialog.show(parentFragmentManager, "test")

            //viewModel.getWeatherLatLong(lat = "44", long = "44")
            //Timber.e("latlong:: ${viewModel.weatherData}")
        }

        /* parentFragment?.view?.rootView?.findViewById<FloatingActionButton>(R.id.fab)
             ?.setOnClickListener {
                 Timber.e("test")
                 viewModel.getWeatherLatLong(lat = "44", long = "44")
                 Timber.e("latlong:: ${viewModel.weatherData}")
             }*/


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
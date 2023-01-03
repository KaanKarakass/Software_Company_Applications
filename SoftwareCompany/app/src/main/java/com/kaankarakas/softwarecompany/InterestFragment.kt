package com.kaankarakas.softwarecompany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InterestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_interest, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        var message = InterestFragmentArgs.fromBundle(requireArguments()).newUser
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        message += "\nInterests: "
        fab.setOnClickListener {
            var chipView = view.findViewById<Chip>(R.id.software_testing)
            message += if(chipView.isChecked) ",software_testing" else ""

            chipView = view.findViewById<Chip>(R.id.Sorting)
            message += if(chipView.isChecked) ",Sorting" else ""

            chipView = view.findViewById<Chip>(R.id.SQL)
            message += if(chipView.isChecked) ",SQL" else ""

            chipView = view.findViewById<Chip>(R.id.Stack)
            message += if(chipView.isChecked) ",Stack" else ""

            chipView = view.findViewById<Chip>(R.id.Stl)
            message += if(chipView.isChecked) ",Stl" else ""

            chipView = view.findViewById<Chip>(R.id.Strings)
            message += if(chipView.isChecked) ",Strings" else ""

            chipView = view.findViewById<Chip>(R.id.Android)
            message += if(chipView.isChecked) ",Android" else ""

            chipView = view.findViewById<Chip>(R.id.Arrays)
            message += if(chipView.isChecked) ",Arrays" else ""

            message = message.toString()
            println(message)
            val action = InterestFragmentDirections.actionInterestFragmentToSummaryFragment(message)
            view.findNavController().navigate(action)
        }
        return view
    }

}
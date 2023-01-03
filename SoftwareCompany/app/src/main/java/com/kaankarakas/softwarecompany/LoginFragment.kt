package com.kaankarakas.softwarecompany

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        val messageView = view.findViewById<EditText>(R.id.plaintext1)
        val passworview = view.findViewById<EditText>(R.id.plaintext2)
        val checkBox = view.findViewById<CheckBox>(R.id.checkbox)
        fab.setOnClickListener {
            val group =view.findViewById<RadioGroup>(R.id.radio_group)
            val type = group.checkedRadioButtonId
            if(type ==-1 ) {
                val text = "You need to choose male or female"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            }else if(passworview.text.toString() =="") {
                val text = "You need to enter your password"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            }else if(!checkBox.isChecked){
                val text = "You need to accept licenses"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            }else{
                var message = messageView.text.toString()
                val femaleView = view.findViewById<RadioButton>(R.id.female)
                message += if(femaleView.isChecked) ", female" else ", male"
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
                val action = LoginFragmentDirections.actionLoginFragmentToInterestFragment(message)
                view.findNavController().navigate(action)

            }

        }
        return view
    }

}
package com.example.firstapp.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.trackmysleepquality.sleeptracker.ContactViewModelFactory
import com.example.firstapp.R
import com.example.firstapp.database.Namelistdatabase
import com.example.firstapp.databinding.FragmentContactBinding

class Contact : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentContactBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_contact, container, false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = Namelistdatabase.getInstance(application).namelistDao

        val viewModelFactory = ContactViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val ContactViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(ContactViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.contactviewmodel = ContactViewModel
        return binding.root

    }

}
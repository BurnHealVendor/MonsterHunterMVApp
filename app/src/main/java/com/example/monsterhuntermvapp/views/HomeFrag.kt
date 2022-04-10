package com.example.monsterhuntermvapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.monsterhuntermvapp.MotionValuesApp
import com.example.monsterhuntermvapp.R
import com.example.monsterhuntermvapp.databinding.FragmentHomeBinding
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.viewmodel.MVViewModel
import com.example.monsterhuntermvapp.viewmodel.MVViewModelFactory
import javax.inject.Inject

class HomeFrag : Fragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }
}
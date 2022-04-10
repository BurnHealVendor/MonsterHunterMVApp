package com.example.monsterhuntermvapp.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.monsterhuntermvapp.MotionValuesApp
import com.example.monsterhuntermvapp.R
import com.example.monsterhuntermvapp.databinding.FragmentHomeBinding
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.utils.WeaponType
import com.example.monsterhuntermvapp.viewmodel.MVViewModel
import com.example.monsterhuntermvapp.viewmodel.MVViewModelFactory
import javax.inject.Inject

class HomeFrag : Fragment() {

    @Inject
    lateinit var mvRepo: MotionValuesRepo

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val mvViewModel by lazy {
        ViewModelProvider(requireActivity(), MVViewModelFactory(mvRepo))[MVViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MotionValuesApp.mvComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.greatSwordBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.GREAT_SWORD
            findNavController().navigate(R.id.action_homeFrag_to_greatSwordFrag)
        }

        return binding.root
    }
}
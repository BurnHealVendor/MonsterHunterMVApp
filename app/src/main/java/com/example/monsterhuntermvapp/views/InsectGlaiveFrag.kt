package com.example.monsterhuntermvapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monsterhuntermvapp.MotionValuesApp
import com.example.monsterhuntermvapp.adapter.MotionValuesAdapter
import com.example.monsterhuntermvapp.databinding.FragmentGreatSwordBinding
import com.example.monsterhuntermvapp.databinding.FragmentInsectGlaiveBinding
import com.example.monsterhuntermvapp.model.MotionValuesItem
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.utils.MotionValuesState
import com.example.monsterhuntermvapp.viewmodel.MVViewModel
import com.example.monsterhuntermvapp.viewmodel.MVViewModelFactory
import javax.inject.Inject

class InsectGlaiveFrag : Fragment() {

    @Inject
    lateinit var motionValuesRepo: MotionValuesRepo

    private val binding by lazy {
        FragmentInsectGlaiveBinding.inflate(layoutInflater)
    }

    private val mvViewModel by lazy {
        ViewModelProvider(requireActivity(), MVViewModelFactory(motionValuesRepo))[MVViewModel::class.java]
    }

    private val mvAdapter by lazy {
        MotionValuesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MotionValuesApp.mvComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.insectGlaiveRecView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = mvAdapter
        }

        mvViewModel.motionValuesLiveData.observe(viewLifecycleOwner) { state ->
            when(state) {
                is MotionValuesState.LOADING -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_LONG).show()
                }
                is MotionValuesState.SUCCESS<*> -> {
                    mvAdapter.setMVData(state.motionValues as List<MotionValuesItem>)
                }
                is MotionValuesState.ERROR -> {
                    Toast.makeText(requireContext(), state.error.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

        mvViewModel.getMotionValues()

        return binding.root
    }
}
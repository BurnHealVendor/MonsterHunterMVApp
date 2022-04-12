package com.example.monsterhuntermvapp.views

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

        binding.longSwordBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.LONG_SWORD
            findNavController().navigate(R.id.action_homeFrag_to_longSwordFrag)
        }

        binding.swordAndShieldBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.SWORD_AND_SHIELD
            findNavController().navigate(R.id.action_homeFrag_to_swordAndShieldFrag)
        }

        binding.dualBladesBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.DUAL_BLADES
            findNavController().navigate(R.id.action_homeFrag_to_dualBladesFrag)
        }

        binding.hammerBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.HAMMER
            findNavController().navigate(R.id.action_homeFrag_to_hammerFrag)
        }

        binding.huntingHornBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.HUNTING_HORN
            findNavController().navigate(R.id.action_homeFrag_to_huntingHornFrag)
        }

        binding.lanceBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.LANCE
            findNavController().navigate(R.id.action_homeFrag_to_lanceFrag)
        }

        binding.gunlanceBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.GUNLANCE
            findNavController().navigate(R.id.action_homeFrag_to_gunlanceFrag)
        }

        binding.switchAxeBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.SWITCH_AXE
            findNavController().navigate(R.id.action_homeFrag_to_switchAxeFrag)
        }

        binding.chargeBladeBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.CHARGE_BLADE
            findNavController().navigate(R.id.action_homeFrag_to_chargeBladeFrag)
        }

        binding.insectGlaiveBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.INSECT_GLAVE
            findNavController().navigate(R.id.action_homeFrag_to_insectGlaiveFrag)
        }

        binding.lightBowgunBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.LIGHT_BOWGUN
            findNavController().navigate(R.id.action_homeFrag_to_lightBowgunFrag)
        }

        binding.heavyBowgunBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.HEAVY_BOWGUN
            findNavController().navigate(R.id.action_homeFrag_to_heavyBowgunFrag)
        }

        binding.bowBtn.setOnClickListener {
            mvViewModel.weaponType = WeaponType.BOW
            findNavController().navigate(R.id.action_homeFrag_to_bowFrag)
        }

        return binding.root
    }
}
package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.game.databinding.FragmentDifficultyBinding

class DifficultyFragment : Fragment() {

	private  lateinit var binding: FragmentDifficultyBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentDifficultyBinding.inflate(inflater, container, false)

		binding.easyButton.setOnClickListener {
			(activity as MainActivity)?.difficulty = 1
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		binding.normalButton.setOnClickListener {
			(activity as MainActivity)?.difficulty = 2
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		binding.hardButton.setOnClickListener {
			(activity as MainActivity)?.difficulty = 3
			(activity as MainActivity)?.onNavigationItemSelected(2)
		}

		return binding.root
	}
}
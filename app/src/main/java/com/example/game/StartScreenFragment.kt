package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.game.databinding.FragmentStartScreenBinding

class StartScreenFragment : Fragment() {

	private lateinit var binding: FragmentStartScreenBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentStartScreenBinding.inflate(inflater, container, false)
		val record = (activity as MainActivity)?.record

		binding.toolbar.record.text = "Max record: $record"

		binding.startButton.setOnClickListener {
			(activity as MainActivity)?.onNavigationItemSelected(1)
		}
		return binding.root
	}
}
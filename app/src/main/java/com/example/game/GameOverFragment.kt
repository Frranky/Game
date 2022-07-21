package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.game.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

	private lateinit var binding: FragmentGameOverBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentGameOverBinding.inflate(inflater, container, false)
		val context = (activity as MainActivity)

		if(context.score > context.record){
			binding.scoreView.text = "New record: ${context.score}"
			context.record = context.score
		}
		else binding.scoreView.text = "Score: ${context.score}"

		val record = (activity as MainActivity)?.record
		binding.toolbar.record.text = "Max record: $record"

		binding.restartButton.setOnClickListener { (activity as MainActivity)?.onNavigationItemSelected(1) }
		binding.menuButton.setOnClickListener { (activity as MainActivity)?.onNavigationItemSelected(3) }

		return binding.root
	}
}
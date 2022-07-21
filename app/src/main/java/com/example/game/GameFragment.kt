package com.example.game

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.game.databinding.FragmentGameBinding
import java.util.Timer
import java.util.TimerTask

class GameFragment : Fragment() {

	private lateinit var binding: FragmentGameBinding
	var score = 0
	private var gameTimer: CountDownTimer? = null
	private var moleInHole: Array<Boolean> =
		arrayOf(
			false, false, false,
			false, false, false,
			false, false, false
		)

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentGameBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.toolbar.record.text = "Score: $score"
		startGameTimer(30000)
		startGame()
		binding.button1.root.setOnClickListener { checkMole(0) }
		binding.button2.root.setOnClickListener { checkMole(1) }
		binding.button3.root.setOnClickListener { checkMole(2) }
		binding.button4.root.setOnClickListener { checkMole(3) }
		binding.button5.root.setOnClickListener { checkMole(4) }
		binding.button6.root.setOnClickListener { checkMole(5) }
		binding.button7.root.setOnClickListener { checkMole(6) }
		binding.button8.root.setOnClickListener { checkMole(7) }
		binding.button9.root.setOnClickListener { checkMole(8) }

	}

	private fun startGameTimer(timeMillis: Long) {
		gameTimer?.cancel()
		gameTimer = object : CountDownTimer(timeMillis, 1000) {
			override fun onTick(timeM: Long) {
				binding.timerTextView.text = ((timeM.toInt() / 1000) + 1).toString()
			}

			override fun onFinish() {
				hideAllMole()
				(activity as MainActivity)?.score = score
				(activity as MainActivity)?.onNavigationItemSelected(2)
			}
		}.start()
	}

	private fun startGame() {
		val randomHole = (0..8).random()
		val moleTimer = Timer()

		showMole(randomHole)
		moleTimer.schedule(object : TimerTask() {
			override fun run() {
				if (moleInHole[randomHole]) {
					hideAllMole()
					startGame()
				}
			}
		}, 500)
	}

	private fun checkMole(hole: Int) {
		if (moleInHole[hole]) {
			score++
			binding.toolbar.record.text = score.toString()
			hideAllMole()
			startGame()
		}
	}

	private fun hideAllMole() {
		moleInHole = arrayOf(
			false, false, false,
			false, false, false,
			false, false, false
		)
		for (i in 0..8) {
			hideMole(i)
		}
	}

	private fun showMole(hole: Int) {
		when (hole + 1) {
			1 -> binding.button1.root.setBackgroundColor(Color.RED)
			2 -> binding.button2.root.setBackgroundColor(Color.RED)
			3 -> binding.button3.root.setBackgroundColor(Color.RED)
			4 -> binding.button4.root.setBackgroundColor(Color.RED)
			5 -> binding.button5.root.setBackgroundColor(Color.RED)
			6 -> binding.button6.root.setBackgroundColor(Color.RED)
			7 -> binding.button7.root.setBackgroundColor(Color.RED)
			8 -> binding.button8.root.setBackgroundColor(Color.RED)
			9 -> binding.button9.root.setBackgroundColor(Color.RED)
		}
		moleInHole[hole] = true
	}

	private fun hideMole(hole: Int) {
		when (hole + 1) {
			1 -> binding.button1.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			2 -> binding.button2.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			3 -> binding.button3.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			4 -> binding.button4.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			5 -> binding.button5.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			6 -> binding.button6.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			7 -> binding.button7.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			8 -> binding.button8.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
			9 -> binding.button9.root.background = ContextCompat.getDrawable(this.requireContext(), R.drawable.button_bg)
		}
		moleInHole[hole] = false
	}
}
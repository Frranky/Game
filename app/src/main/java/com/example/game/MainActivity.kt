package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	var record = 0
	var score = 1
	var difficulty = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		supportFragmentManager.beginTransaction().add(R.id.container, StartScreenFragment()).commit()
	}

	fun onNavigationItemSelected(item: Int){

		when(item) {
			1 -> supportFragmentManager.beginTransaction().replace(R.id.container, DifficultyFragment()).commit()
			2 -> supportFragmentManager.beginTransaction().replace(R.id.container, GameFragment()).commit()
			3 -> supportFragmentManager.beginTransaction().replace(R.id.container, GameOverFragment()).commit()
			4 -> supportFragmentManager.beginTransaction().replace(R.id.container, StartScreenFragment()).commit()
		}
	}
}
package com.example.colormyview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.colormyview.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up padding to accommodate system windows
        ViewCompat.setOnApplyWindowInsetsListener(binding.constantLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Click()
    }

    private fun Click() {
        // Initialize your views using View Binding
        val btn: List<View> = listOf(
            binding.boxOne,
            binding.boxTwo,
            binding.boxThree,
            binding.boxFour,
            binding.boxFive,
            binding.boxSix,
            binding.boxSeven,
            binding.box8,
            binding.box9,
            binding.box10,
            binding.box11,
            binding.box12,
            binding.constantLayout,
            binding.redButton,
            binding.yellowButton,
            binding.greenButton
        )

        // Set onClickListeners for each view in the list
        for (item in btn) {
            item.setOnClickListener { makeColoured(it) }
        }
    }
    private var redButtonClickCount = 0
    private var yellowButtonClickCount = 0
    private var greenButtonClickCount = 0

    private fun makeColoured(view: View) {
        when (view.id) {
            R.id.red_button -> {
                redButtonClickCount++
                when (redButtonClickCount) {
                    1 -> binding.boxOne.setBackgroundResource(R.color.red)
                    2 -> binding.boxFive.setBackgroundResource(R.color.red)
                    3 -> binding.box9.setBackgroundResource(R.color.red)
                    4 -> binding.box12.setBackgroundResource(R.color.red)
                    else -> redButtonClickCount = 0 // Reset count
                }
            }
            R.id.yellow_button -> {
                yellowButtonClickCount++
                when (yellowButtonClickCount) {
                    1 -> binding.boxTwo.setBackgroundResource(R.color.yellow)
                    2 -> binding.boxSix.setBackgroundResource(R.color.yellow)
                    3 -> binding.box8.setBackgroundResource(R.color.yellow)
                    4 -> binding.boxThree.setBackgroundResource(R.color.yellow)
                    else -> yellowButtonClickCount = 0 // Reset count
                }
            }
            R.id.green_button -> {
                greenButtonClickCount++
                when (greenButtonClickCount) {
                    1 -> binding.box11.setBackgroundResource(R.color.green)
                    2 -> binding.boxFour.setBackgroundResource(R.color.green)
                    3 -> binding.boxSeven.setBackgroundResource(R.color.green)
                    4 -> binding.box10.setBackgroundResource(R.color.green)
                    else -> greenButtonClickCount = 0 // Reset count
                }
            }
            else -> view.setBackgroundResource(R.color.cyan)
        }
    }


}

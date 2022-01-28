package com.example.mvpproject

import android.os.Bundle
import android.view.View
import com.example.mvpproject.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            val currentButton =
                when (it.id) {
                    R.id.button_counter1 -> MainPresenter.ButtonId.BUTTON_ONE
                    R.id.button_counter2 -> MainPresenter.ButtonId.BUTTON_TWO
                    R.id.button_counter3 -> MainPresenter.ButtonId.BUTTON_THREE
                    else -> throw IllegalArgumentException("Wrong button ID!")
                }
            presenter.counterClick(currentButton)
        }

        binding.buttonCounter1.setOnClickListener(listener)
        binding.buttonCounter2.setOnClickListener(listener)
        binding.buttonCounter3.setOnClickListener(listener)
    }

    override fun setButtonOneText(text: String) {
        binding.buttonCounter1.text = text
    }

    override fun setButtonTwoText(text: String) {
        binding.buttonCounter2.text = text
    }

    override fun setButtonThreeText(text: String) {
        binding.buttonCounter3.text = text
    }
}
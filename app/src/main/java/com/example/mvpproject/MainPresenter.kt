package com.example.mvpproject

import moxy.MvpPresenter

class MainPresenter(private val model: CountersModel): MvpPresenter<MainView>() {

    fun counterClick(id: ButtonId) {
        when (id) {
            ButtonId.BUTTON_ONE -> {
                val nextValue = model.next(0)
                viewState.setButtonOneText(nextValue.toString())
            }
            ButtonId.BUTTON_TWO -> {
                val nextValue = model.next(1)
                viewState.setButtonTwoText(nextValue.toString())
            }
            ButtonId.BUTTON_THREE -> {
                val nextValue = model.next(2)
                viewState.setButtonThreeText(nextValue.toString())
            }
        }
    }

    enum class ButtonId {
        BUTTON_ONE,
        BUTTON_TWO,
        BUTTON_THREE
    }
}
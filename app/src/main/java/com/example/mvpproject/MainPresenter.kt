package com.example.mvpproject

class MainPresenter(val view: MainView) {

    private val model = CountersModel()

    fun counterClick(id: ButtonId) {
        when (id) {
            ButtonId.BUTTON_ONE -> {
                val nextValue = model.next(0)
                view.setButtonOneText(nextValue.toString())
            }
            ButtonId.BUTTON_TWO -> {
                val nextValue = model.next(1)
                view.setButtonTwoText(nextValue.toString())
            }
            ButtonId.BUTTON_THREE -> {
                val nextValue = model.next(2)
                view.setButtonThreeText(nextValue.toString())
            }
        }
    }

    enum class ButtonId {
        BUTTON_ONE,
        BUTTON_TWO,
        BUTTON_THREE
    }
}
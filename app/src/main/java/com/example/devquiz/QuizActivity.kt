package com.example.devquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.devquiz.model.Constants
import com.example.devquiz.model.Question
import org.jetbrains.anko.toast

class QuizActivity : AppCompatActivity() {

    private var position: Int = 1
    private var questionList: ArrayList<Question>? = null
    private var selectedPosition: Int = 0

    private var correctAnswers: Int = 0

    private val progressBar by lazy { findViewById<ProgressBar>(R.id.progressBar) }
    private val numberQuestion by lazy { findViewById<TextView>(R.id.textQuestionNumber) }
    private val titleQuestion by lazy { findViewById<TextView>(R.id.titleQuestion) }
    private val optionOne by lazy { findViewById<Button>(R.id.buttonOptionOne) }
    private val optionTwo by lazy { findViewById<Button>(R.id.buttonOptionTwo) }
    private val optionThree by lazy { findViewById<Button>(R.id.buttonOptionThree) }
    private val optionFour by lazy { findViewById<Button>(R.id.buttonOptionFour) }
    private val buttonConfirm by lazy { findViewById<Button>(R.id.buttonConfirm) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionList = Constants.getQuestions()

        viewQuestion()

        optionOne.setOnClickListener {
            selectedOption(optionOne, 1)
        }

        optionTwo.setOnClickListener {
            selectedOption(optionTwo, 2)
        }

        optionThree.setOnClickListener {
            selectedOption(optionThree, 3)
        }

        optionFour.setOnClickListener {
            selectedOption(optionFour, 4)
        }

        buttonConfirm.setOnClickListener {
            if(selectedPosition == 0) {
                val warning = getString(R.string.stringWarning)
                toast(warning)
            } else {
                val question = questionList?.get(position - 1)
                if(question!!.correctAnswer != selectedPosition) {
                    answerView(selectedPosition, R.drawable.ic_style_button_question_wrong,"#F44336")
                } else {
                    correctAnswers++
                }
                answerView(question.correctAnswer, R.drawable.ic_style_button_question_correct, "#4CAF50")
                buttonConfirm.isClickable = false
                position++
                if(position <= questionList!!.size) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        viewQuestion()
                    }, 3000)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed({
                        setScore()
                        finish()
                    }, 3000)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun viewQuestion() {
        val question = questionList!![position - 1]

        selectedPosition = 0
        buttonConfirm.isClickable = true

        progressBar.progress = position
        numberQuestion.text = "$position"
        titleQuestion.text = question.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour

        defaultOptionsView()
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (option in options) {
            if(resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) {
                option.setTextColor(Color.parseColor("#F5F5FA"))
                option.background = ContextCompat.getDrawable(this, R.drawable.ic_style_button_question_night_mode)
            } else {
                option.setTextColor(Color.parseColor("#475966"))
                option.background = ContextCompat.getDrawable(this, R.drawable.ic_style_button_question)
            }
        }
    }

    private fun selectedOption(text: TextView, OptionNumber: Int) {
        defaultOptionsView()
        selectedPosition = OptionNumber
        text.setTextColor(Color.parseColor("#00BCD4"))
        text.background = ContextCompat.getDrawable(this, R.drawable.ic_style_button_question_selected)
    }

    private fun answerView(answer: Int, drawableView: Int, color: String) {
        when(answer) {
            1-> {
                optionOne.setTextColor(Color.parseColor(color))
                optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2-> {
                optionTwo.setTextColor(Color.parseColor(color))
                optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3-> {
                optionThree.setTextColor(Color.parseColor(color))
                optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4-> {
                optionFour.setTextColor(Color.parseColor(color))
                optionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun setScore() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
        intent.putExtra(Constants.TOTAL_QUESTIONS, questionList!!.size)

        startActivity(intent)
    }
}
package com.example.devquiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.devquiz.model.Constants
import org.jetbrains.anko.startActivity

class ResultActivity : AppCompatActivity() {

    private val textFinish by lazy { findViewById<TextView>(R.id.textDescriptionFinish) }
    private val buttonCallBack by lazy { findViewById<TextView>(R.id.buttonCallBack) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        getScore()

        buttonCallBack.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getScore() {
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val finishDescription = getString(R.string.stringFinishDescription)
        val outOof = getString(R.string.stringFromQuestion)
        val hits = getString(R.string.stringHits)

        textFinish.text = "$finishDescription $correctAnswers $outOof $totalQuestions $hits"
    }
}
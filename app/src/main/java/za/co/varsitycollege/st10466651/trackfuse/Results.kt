package za.co.varsitycollege.st10466651.trackfuse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Results : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val review = findViewById<Button>(R.id.btnReview)
        val retry = findViewById<Button>(R.id.btnRetry)
        val close = findViewById<Button>(R.id.btnCLose)
        val scores = findViewById<TextView>(R.id.txtScores)
        val feedBack = findViewById<TextView>(R.id.txtFeedback)
        val answers = findViewById<TextView>(R.id.txtReview)
        var amount = 0

        scores.text = "Your Score is: ${score}/5"


        review.setOnClickListener {
            answers.text = "Question: ${questionList[0].question}\n" +
                    "Answer: ${questionList[0].answer}\n" +
                    "Your Answer: ${questionList[0].userAnswer}\n\n" +
                    "Question: ${questionList[1].question}\n" +
                    "Answer: ${questionList[1].answer}\n" +
                    "Your Answer: ${questionList[1].userAnswer}\n\n" +
                    "Question: ${questionList[2].question}\n" +
                    "Answer: ${questionList[2].answer}\n" +
                    "Your Answer: ${questionList[2].userAnswer}\n\n" +
                    "Question: ${questionList[3].question}\n" +
                    "Answer: ${questionList[3].answer}\n" +
                    "Your Answer: ${questionList[3].userAnswer}\n\n" +
                    "Question: ${questionList[4].question}\n" +
                    "Answer: ${questionList[4].answer}\n" +
                    "Your Answer: ${questionList[4].userAnswer}\n\n"
        }



        close.setOnClickListener{
        finishAffinity() // Closes the app
        }

        retry.setOnClickListener{
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
            currentIndex = 0
            score = 0
        }
        val feedback = when {
        score >= 3 -> "Great Job!!!"
        else -> "Unlucky!!!"
        }
        feedBack.text = feedback
    }
}
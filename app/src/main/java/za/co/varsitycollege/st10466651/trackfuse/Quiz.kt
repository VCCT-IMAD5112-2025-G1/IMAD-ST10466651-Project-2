package za.co.varsitycollege.st10466651.trackfuse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
data class questionList(
    val question: String,
    val answer: Boolean,
    var userAnswer: Boolean? = null
)

var currentIndex = 0

class Quiz : AppCompatActivity() {

    private val questionList = mutableListOf(
        questionList("The Great Fire of London in 1666 started in a bakery.", true),
        questionList("Julius Caesar was the first Emperor of Rome.", false),
        questionList("The Berlin Wall fell in 1989, leading to the reunification of Germany.", true),
        questionList("Napoleon Bonaparte was born in France.", false),
        questionList("The Cold War involved direct military combat between the USA and the Soviet Union.", false)
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val questions = findViewById<TextView>(R.id.txtQuestions)
        val right = findViewById<Button>(R.id.btnTrue)
        val wrong = findViewById<Button>(R.id.btnFalse)
        val next = findViewById<Button>(R.id.btnNext)
        val end = findViewById<Button>(R.id.btnDone)
        var counter = 0
        end.visibility = View.GONE
        showQuestion()

        next.setOnClickListener {
            counter++
            questions.text = questionList[counter].question
            wrong.isEnabled = true
            right.isEnabled = true
            if(counter == 4) {
                next.visibility = View.GONE
                end.visibility = View.VISIBLE
            }
        }

        right.setOnClickListener {
            wrong.isEnabled = false
            // User answers "true" for the first question
            questionList[currentIndex].userAnswer = true
            checkAnswer(true)

        }

        wrong.setOnClickListener {
            right.isEnabled = false
            // User answers "false" for the first question
            questionList[currentIndex].userAnswer = false
            checkAnswer(false)
        }

        end.setOnClickListener {
            val intent = Intent(this, Results::class.java)
            startActivity(intent)
        }
    }

    fun showQuestion() {
        val questions = findViewById<TextView>(R.id.txtQuestions)
        val currentQuestion = questionList[currentIndex]
        questions.text = currentQuestion.question
    }

    private fun checkAnswer(userChoice: Boolean) {
        val currentQuestion = questionList[currentIndex]
        currentQuestion.userAnswer = userChoice

        val isCorrect = currentQuestion.userAnswer == currentQuestion.answer

        Toast.makeText(
            this,
            if (isCorrect) "Correct! 🎉" else "Wrong! ❌",
            Toast.LENGTH_SHORT
        ).show()

        // Move to next question (optional)
        if (currentIndex < questionList.size - 1) {
            currentIndex++
            // update UI with new question here
        } else {
            Toast.makeText(this, "Quiz finished!", Toast.LENGTH_SHORT).show()
            // Maybe show final score
        }
    }
}
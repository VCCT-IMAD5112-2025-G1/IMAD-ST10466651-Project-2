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

        scores.text = "Your Score is: ${score}/5"

        review.setOnClickListener {

        }


        close.setOnClickListener{
        finishAffinity() // Closes the app
        }

        retry.setOnClickListener{
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
        currentIndex = 0
        }
        val feedback = when {
        score >= 3 -> "Great Job!!!"
        else -> "Unlucky!!!"
        }
        feedBack.text = feedback
    }
}
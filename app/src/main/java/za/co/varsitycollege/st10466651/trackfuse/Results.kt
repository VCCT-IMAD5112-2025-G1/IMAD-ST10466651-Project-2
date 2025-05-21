package za.co.varsitycollege.st10466651.trackfuse

import android.content.Intent
import android.os.Bundle
import android.util.Log.i
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Results : AppCompatActivity() {
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


        review.setOnClickListener {


        }


    close.setOnClickListener{
        finishAffinity() // Closes the app
    }

    retry.setOnClickListener{
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
    }

    }
}
package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewActivity : AppCompatActivity() {

    private lateinit var tpmTextView: TextView
    private lateinit var songListButton: Button
    private lateinit var outputTextView: TextView
    private lateinit var averageButton: Button
    private lateinit var returnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.view_screen)

        tpmTextView = findViewById(R.id.tpmTextView)
        outputTextView = findViewById(R.id.outputTextView)
        songListButton = findViewById(R.id.songListButton)
        averageButton = findViewById(R.id.averageButton)
        returnButton = findViewById(R.id.returnButton)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getStringArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val result = StringBuilder()
        for (i in titles.indices) {
            result.append("Song ${i + 1} \n")
            result.append("Title: ${titles[i]}\n")
            result.append("Artists: ${artists[i]}\n")
            result.append("Rating: ${ratings[i]}\n")
            result.append("Comment: ${comments[i]}\n\n}")
        }

        songListButton.setOnClickListener{
            val builder = StringBuilder()
        }

        returnButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.view)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}
}
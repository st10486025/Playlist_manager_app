package vcmsa.ci.playlistmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val maxSongs = 4

    private lateinit var playlistTextView: TextView
    private lateinit var playlistButton: Button
    private lateinit var stEditText: EditText
    private lateinit var artistNameEditText: EditText
    private lateinit var ratingEditText: EditText
    private lateinit var commentsEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val titles = ArrayList<String>()
        val artists = ArrayList<String>()
        val ratings = ArrayList<String>()
        val comments = ArrayList<String>()


        playlistTextView = findViewById(R.id.playlistTextView)
        playlistButton = findViewById(R.id.playlistButton)
        stEditText = findViewById(R.id.stEditText)
        artistNameEditText = findViewById(R.id.artistNameEditText)
        ratingEditText = findViewById(R.id.ratingEditText)
        commentsEditText = findViewById(R.id.commentsEditText)
        nextButton = findViewById(R.id.nextButton)
        exitButton = findViewById(R.id.exitButton)

        playlistButton.setOnClickListener {
            if (titles.size >= maxSongs) {
                Toast.makeText(this, "Maximum of 4 songs", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        titles.add(title.toString())
        artists.add(artists.toString())
        ratings.add(ratings.toString())
        comments.add(comments.toString())

        stEditText.text.clear()
        artistNameEditText.text.clear()
        ratingEditText.text.clear()
        commentsEditText.text.clear()

        Toast.makeText(this, "Song  added to playlist", Toast.LENGTH_SHORT).show()


        nextButton.setOnClickListener{
            val intent = Intent(this, ViewActivity::class.java)
            intent.putStringArrayListExtra("titles", titles)
            intent.putStringArrayListExtra("artists", artists)
            intent.putStringArrayListExtra("ratings", ratings)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }

        exitButton.setOnClickListener{
            finishAffinity()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
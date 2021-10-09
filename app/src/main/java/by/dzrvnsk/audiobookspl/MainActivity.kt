package by.dzrvnsk.audiobookspl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.dzrvnsk.audiobookspl.databinding.ActivityMainBinding
import by.dzrvnsk.audiobookspl.fragments.ListOfAudiobooksFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, ListOfAudiobooksFragment())
            .commit()
    }
}
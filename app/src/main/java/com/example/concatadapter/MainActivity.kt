package com.example.concatadapter

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concatadapter.adapter.HorizontalAdapter
import com.example.concatadapter.adapter.TitleCardAdapter
import com.example.concatadapter.adapter.VerticalAdapter
import com.example.concatadapter.data.GamesData
import com.example.concatadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var verticalAdapter: VerticalAdapter
    private val horizontalTitle = TitleCardAdapter("Horizontal")
    private val verticalTitle = TitleCardAdapter("Vertical")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val games = mutableListOf(
            GamesData(R.drawable.minecraft, "Minecraft"),
            GamesData(R.drawable.baldurs, "Baldurs Gate"),
            GamesData(R.drawable.ff7, "Final Fantasy VII Remake"),
            GamesData(R.drawable.eldenring, "Elden Ring"),
            GamesData(R.drawable.fallout4, "Fallout 4"),
            GamesData(R.drawable.hades, "Hades"),
            GamesData(R.drawable.pokemonsword, "Pokemon Sword"),
            GamesData(R.drawable.re4, "Resident Evil 4"),
            GamesData(R.drawable.spiderman, "Marvel's Spider-Man"),
            GamesData(R.drawable.tombrider, "Tomb Raider"),
            GamesData(R.drawable.witcher3, "Witcher 3"),
            GamesData(R.drawable.zelda, "The Legend of Zelda: Tears of the Kingdom")
        )

        horizontalAdapter = HorizontalAdapter(games)
        verticalAdapter = VerticalAdapter(games)

        var concatAdapter =
            ConcatAdapter(verticalTitle, verticalAdapter, horizontalTitle, horizontalAdapter)

        binding.mainRV.adapter = concatAdapter
        binding.mainRV.layoutManager = LinearLayoutManager(this)

    }
}
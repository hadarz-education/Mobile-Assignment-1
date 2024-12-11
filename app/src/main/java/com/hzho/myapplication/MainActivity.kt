package com.hzho.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var statusTextView: TextView
    private lateinit var resetButton: Button
    private lateinit var gameGrid: GridLayout
    private var board = Array(3) { Array(3) { "" } } // Game board state
    private var currentPlayer = "X"
    private var gameActive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusTextView = findViewById(R.id.tvStatus)
        resetButton = findViewById(R.id.btnReset)
        gameGrid = findViewById(R.id.gameGrid)

//        initializeBoard()

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    private fun isBoardFull(): Boolean {
        for (row in board) {
            if (row.contains("")) return false
        }
        return true
    }

    private fun resetGame() {
        board = Array(3) { Array(3) { "" } }
        currentPlayer = "X"
        gameActive = true
        statusTextView.text = "Player X's Turn"
//        initializeBoard()
    }
}
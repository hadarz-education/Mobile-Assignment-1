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

        initializeBoard()

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    private fun initializeBoard() {
        for (i in 0 until gameGrid.childCount) {
            val button = gameGrid.getChildAt(i) as Button
            button.text = ""
            button.setOnClickListener {
                handleMove(button)
            }
        }
    }

    private fun handleMove(button: Button) {
        if (!gameActive) return

        val tag = button.tag.toString().split(",")
        val row = tag[0].toInt()
        val col = tag[1].toInt()

        if (board[row][col].isNotEmpty()) return // Cell already taken

        board[row][col] = currentPlayer
        button.text = currentPlayer

        if (checkWin()) {
            statusTextView.text = "Player $currentPlayer Wins!"
            gameActive = false
        } else if (isBoardFull()) {
            statusTextView.text = "It's a Draw!"
            gameActive = false
        } else {
            currentPlayer = if (currentPlayer == "X") "O" else "X"
            statusTextView.text = "Player $currentPlayer's Turn"
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
        initializeBoard()
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
        initializeBoard()
    }
}
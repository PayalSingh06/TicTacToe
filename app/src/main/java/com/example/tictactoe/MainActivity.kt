package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtWinner :TextView
    private lateinit var btn1 :Button
    private lateinit var btn2 :Button
    private lateinit var btn3 :Button
    private lateinit var btn4 :Button
    private lateinit var btn5 :Button
    private lateinit var btn6 :Button
    private lateinit var btn7 :Button
    private lateinit var btn8 :Button
    private lateinit var btn9 :Button
    private lateinit var btnReset : Button
    private lateinit var arrayP1 : ArrayList<Int>
    private lateinit var arrayP2 : ArrayList<Int>
    private var player = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayP1 = ArrayList()
        arrayP2 = ArrayList()

        txtWinner = findViewById(R.id.textViewWin)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)
        btnReset = findViewById(R.id.buttonReset)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.button1 -> {
                play(1)
            }
            R.id.button2 -> {
                play(2)
            }
            R.id.button3 -> {
                play(3)
            }
            R.id.button4 -> {
                play(4)
            }
            R.id.button5 -> {
                play(5)
            }
            R.id.button6 -> {
                play(6)
            }
            R.id.button7 -> {
                play(7)
            }
            R.id.button8 -> {
                play(8)
            }
            R.id.button9 -> {
                play(9)
            }
            R.id.buttonReset -> {
                txtWinner.text = "Status :"
                reset()
            }
        }
    }

    private fun play(buttonNo :Int){

        val id = when(buttonNo){
            1 -> btn1
            2 -> btn2
            3 -> btn3
            4 -> btn4
            5 -> btn5
            6 -> btn6
            7 -> btn7
            8 -> btn8
            else -> btn9
        }

        if (player == 1){
            if (arrayP1.contains(buttonNo) || arrayP2.contains(buttonNo)){
                Toast.makeText(this, "Invalid Move!", Toast.LENGTH_SHORT).show()
            }else {
                id.text = "X"
                arrayP1.add(buttonNo)
                player = 2
            }
        }else{
            if (arrayP1.contains(buttonNo) || arrayP2.contains(buttonNo)){
                Toast.makeText(this, "Invalid Move!", Toast.LENGTH_SHORT).show()
            }else {
                id.text = "O"
                arrayP2.add(buttonNo)
                player = 1
            }
        }

        checkWinner()
    }

    @SuppressLint("SetTextI18n")
    private fun checkWinner(){

        //Row 1
        if (arrayP1.contains(1) && arrayP1.contains(2) && arrayP1.contains(3)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(1) && arrayP2.contains(2) && arrayP2.contains(3)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //Row 2
        if (arrayP1.contains(4) && arrayP1.contains(5) && arrayP1.contains(6)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(4) && arrayP2.contains(5) && arrayP2.contains(6)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //Row 3
        if (arrayP1.contains(7) && arrayP1.contains(8) && arrayP1.contains(9)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(7) && arrayP2.contains(8) && arrayP2.contains(9)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //Col 1
        if (arrayP1.contains(1) && arrayP1.contains(4) && arrayP1.contains(7)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(1) && arrayP2.contains(4) && arrayP2.contains(7)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //Col 2
        if (arrayP1.contains(2) && arrayP1.contains(5) && arrayP1.contains(8)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(2) && arrayP2.contains(5) && arrayP2.contains(8)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //Col 3
        if (arrayP1.contains(3) && arrayP1.contains(6) && arrayP1.contains(9)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(3) && arrayP2.contains(6) && arrayP2.contains(9)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //D 1
        if (arrayP1.contains(1) && arrayP1.contains(5) && arrayP1.contains(9)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(1) && arrayP2.contains(5) && arrayP2.contains(9)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //D 2
        if (arrayP1.contains(3) && arrayP1.contains(5) && arrayP1.contains(7)){
            txtWinner.text = "Win :Player 1"
            reset()
        }
        if (arrayP2.contains(3) && arrayP2.contains(5) && arrayP2.contains(7)){
            txtWinner.text = "Win :Player 2"
            reset()
        }

        //draw
        else if  (arrayP1.size + arrayP2.size == 9){
            txtWinner.text = "Status :Draw!"
            reset()
        }
    }

    private fun reset(){
        player = 1
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""
        arrayP1.clear()
        arrayP2.clear()

    }
}
package com.samir.warcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    lateinit var leftCard: ImageView
    lateinit var rightCard: ImageView
    lateinit var playerScore: TextView
    lateinit var cpuScore: TextView
    lateinit var dealbtn: ImageView
    lateinit var winnerText: TextView
    lateinit var restart: Button
    var player = 0
    var cpu = 0
    var score = 0
    val maxScore = 10

    fun deal(view: View){
        leftCard = findViewById(R.id.leftCard)
        rightCard = findViewById(R.id.rightCard)
        playerScore = findViewById(R.id.playerScore)
        cpuScore = findViewById(R.id.cpuScore)
        winnerText = findViewById(R.id.winnerText)
        dealbtn = findViewById(R.id.dealButton)
        restart = findViewById(R.id.restart)

        val numberLeft = (2..14).random()
        val numberRight = (2..14).random()

        val idLeft = resources.getIdentifier("@drawable/card$numberLeft", null, packageName)
        leftCard.setImageResource(idLeft)
        val idRight = resources.getIdentifier("@drawable/card$numberRight", null, packageName)
        rightCard.setImageResource(idRight)



        if(numberLeft > numberRight){
            player += 1
            playerScore.text = player.toString()
        } else if (numberRight > numberLeft){
            cpu += 1
            cpuScore.text = cpu.toString()
        }

        score = if(player > cpu){
            player
        }else{
            cpu
        }

        if(score == maxScore){
            if(player > cpu){
                dealbtn.visibility = View.INVISIBLE
                restart.visibility = View.VISIBLE
                winnerText.text = "Player won!"
            }else if (cpu > player){
                dealbtn.visibility = View.INVISIBLE
                restart.visibility = View.VISIBLE
                winnerText.text = "CPU won!"
            }
        }
    }

    fun restart(view: View){
        leftCard.setImageResource(R.drawable.back)
        rightCard.setImageResource(R.drawable.back)
        player = 0
        cpu = 0
        score = 0
        winnerText.text = ""
        playerScore.text = "0"
        cpuScore.text = "0"
        dealbtn.visibility = View.VISIBLE
        restart.visibility = View.INVISIBLE
    }

}

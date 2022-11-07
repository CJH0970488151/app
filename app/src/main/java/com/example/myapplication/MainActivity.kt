package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<EditText>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReanswer = findViewById<Button>(R.id.btn_reanswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showanswer)
        var index = 0
        val riddleList = mutableListOf("0000，猜一成語。:四大皆空","人有他大，天沒他大。:一","1+2+3，猜一成語。:接二連三","5，10，猜一成語。:一五一十")
        edAnswer.text = null
        tvResult.text = null
        btnRiddle.setOnClickListener {
            edAnswer.text = null
            tvResult.text = null
            index = (Math.random()*4).toInt()
            val (riddle,answer) = riddleList[index].split(":")
            tvRiddle.text = "謎題:" + riddle


            btnAnswer.setOnClickListener {
            val ans = edAnswer.text
                if (ans.toString()==answer){
                    tvResult.text="答對了"
                    Toast.makeText(this,edAnswer.text,Toast.LENGTH_SHORT).show()
                }
                else{
                    tvResult.text = "沒猜中，再接再厲!"
                }
            }
            btnReanswer.setOnClickListener {
                edAnswer.text = null
                tvResult.text = null
            }
            btnShowAnswer.setOnClickListener {
                tvResult.text = "謎底是:"+answer
            }
        }
    }
}
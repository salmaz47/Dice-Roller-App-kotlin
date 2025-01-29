package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var value1=6
    var value2=5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val image : ImageView = findViewById(R.id.image1)
        val image2 : ImageView = findViewById(R.id.image2)
        val btn : Button = findViewById(R.id.btn)



        if(savedInstanceState!=null)
        {
            value1=savedInstanceState.getInt("dice1",6)
            value2=savedInstanceState.getInt("dice2",5)
        }
        image.setImageResource(getImage(value1))
        image2.setImageResource(getImage(value2))
        btn.setOnClickListener {
            value1=(1..6).random()
            value2=(1..6).random()
            image.setImageResource(getImage(value1))
            image2.setImageResource(getImage(value2))
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("dice1",value1)
        outState.putInt("dice2",value2)
    }
    fun getImage(value: Int) : Int
    {
        return when (value)
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
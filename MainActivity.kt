package com.usercfaft.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.lang.Override as Override1

class MainActivity : AppCompatActivity(), OnClickListener {

   lateinit var question :TextView
   lateinit var image :ImageView
    lateinit var button1 :Button
   lateinit var button2 :Button
   lateinit var button3 :Button
   lateinit var button4 :Button
   lateinit var Submit :Button
    lateinit var counter :TextView


    var score:Int =0
    var curindex:Int =0
    var selans:String = ""
    var totalque :Int = database("Prashant").que.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         question = findViewById(R.id.question) as TextView
         image =  findViewById(R.id.image) as ImageView
         button1 = findViewById(R.id.option1) as Button
         button2 = findViewById(R.id.option2) as Button
         button3 = findViewById(R.id.option3) as Button
         button4 = findViewById(R.id.option4) as Button
         Submit =  findViewById(R.id.submit) as Button
        counter = findViewById(R.id.counter) as TextView


        button4.setOnClickListener(this)
        button3.setOnClickListener (this)
        button2.setOnClickListener (this)
        button1.setOnClickListener (this)
        Submit.setOnClickListener (this)



  counter.setText(curindex.toString())

   loadque(curindex )




    }



    override fun onClick(v: View?) {


        var clicked: Button = v as Button

        if (clicked.id == Submit.id) {

            curindex++

            if( curindex == totalque)
            {
                Toast.makeText(this, "Quiz Finished", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)


            }

                loadque(curindex)

            }



        else {

            selans = clicked.text.toString()
            clicked.setBackgroundColor(Color.MAGENTA)

            if (selans.equals(database("Prashant").ans[curindex]))
            {
                Toast.makeText(this, "Right answer", Toast.LENGTH_SHORT).show()
                clicked.setBackgroundColor(Color.BLUE)
                score++
                counter.setText(score.toString())
            }
            else {
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_LONG).show()
                clicked.setBackgroundColor(Color.BLUE)
            }



        }
    }
        private fun loadque(curindex:Int) {

            question.setText(database("Prashant").que[curindex] )
            image.setImageResource(database("Prashant").images[curindex])
            button1.setText(database("Prashant").options[curindex][0])
            button2.setText(database("Prashant").options[curindex][1])
            button3.setText(database("Prashant").options[curindex][2])
            button4.setText(database("Prashant").options[curindex][3])
        }






}
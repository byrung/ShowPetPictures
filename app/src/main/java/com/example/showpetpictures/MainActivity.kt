package com.example.showpetpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    lateinit var checkStart : CheckBox
    lateinit var rg : RadioGroup
    lateinit var linearSub : LinearLayout
    lateinit var btnDone : Button
    lateinit var imgV : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkStart = findViewById<CheckBox>(R.id.checkStart)
        rg = findViewById<RadioGroup>(R.id.rg)
        linearSub = findViewById<LinearLayout>(R.id.linerSub)
        btnDone = findViewById<Button>(R.id.btnDone)
        imgV = findViewById<ImageView>(R.id.imgV)

        checkStart.setOnCheckedChangeListener { buttonView, isChecked ->
         if(isChecked){
            linearSub.visibility= View.VISIBLE
         }else{
             linearSub.visibility=View.INVISIBLE
         }
        }

        btnDone.setOnClickListener {
            when(rg.checkedRadioButtonId){
                R.id.Dog -> imgV.setImageResource(R.drawable.dog)
                R.id.Cat -> imgV.setImageResource(R.drawable.cat)
                R.id.Bird -> imgV.setImageResource(R.drawable.bird)
            }
        }
    }

    val btnListener = OnClickListener{
        when(it.id){
            R.id.btnFinish -> finish()
            R.id.btnInit -> {
                checkStart.isChecked = false
                linearSub.visibility = INVISIBLE
            }
        }
    }
}
package com.example.imagestext

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var image1 : ImageView
    lateinit var image2 : ImageView
    lateinit var btnDrawText : Button
    lateinit var textIn : EditText
    lateinit var textIn2 : EditText
    lateinit var bitmapOriginal : Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDrawText = findViewById(R.id.drawtext)
        textIn = findViewById(R.id.textin)
        textIn2 = findViewById(R.id.textin2)

        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)

        bitmapOriginal = BitmapFactory.decodeResource(resources,R.drawable.dog)

       

        image1.setImageBitmap(bitmapOriginal)
        btnDrawText.setOnClickListener{
            println("Button Listner")
            reloadImage()
        }
        reloadImage()
    }

    fun reloadImage(){
        println("Reload image")
        val textToDraw = textIn.text.toString()
        val textToDraw2 = textIn2.text.toString()
        val newBitmap = bitmapOriginal.copy(bitmapOriginal.config,true)
        val newCanvas = Canvas(newBitmap)
        //newCanvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        paint.color = Color.RED
        paint.textSize = 500.0F
        val bounds = Rect()
        paint.getTextBounds(textToDraw,0,textToDraw.length,bounds)
        paint.getTextBounds(textToDraw2,0,textToDraw2.length,bounds)
        val x =0
        val y = newBitmap.height
        val g = newBitmap.height
        val h =0
        newCanvas.drawText(textToDraw,x.toFloat(),y.toFloat(),paint)
        newCanvas.drawText(textToDraw2,g.toFloat(),h.toFloat(),paint)

        image1.setImageBitmap(newBitmap)
        image2.setImageBitmap(newBitmap)
    }
}
package com.example.fotobook

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.fotobook.constant.Const
import com.example.fotobook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private val fhotoIdList = arrayListOf(
        R.drawable.im1,
        R.drawable.im2,
        R.drawable.im3,
        R.drawable.im4,
        R.drawable.im5,
        R.drawable.im6
    )
    private var counterImageIndex = 0
    private var imageID = R.drawable.im1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarsup()
        initButton()
    }
    private fun actionBarsup(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tittle_on2_actionbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) finish()
        return true
    }


    private fun initButton() = with(binding){
        bNext.setOnClickListener {
            counterImageIndex++
            if(counterImageIndex > fhotoIdList.size -1) counterImageIndex = 0
            imageID = fhotoIdList[counterImageIndex]
            imageView.setImageResource(imageID)
        }
        bDone.setOnClickListener {
            val fhoto = Fhoto(imageID, tittle.text.toString(),edDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra(Const.PHOTO_KEY, fhoto)
            }
            setResult(RESULT_OK, editIntent)
            finish()
            }
        }
    }

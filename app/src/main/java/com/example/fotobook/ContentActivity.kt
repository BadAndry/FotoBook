package com.example.fotobook

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.fotobook.constant.Const
import com.example.fotobook.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarsup()
        val item = intent.getSerializableExtra(Const.ITEM) as Fhoto
        binding.apply {
            imageView2.setImageResource(item.imageId)
            title2.text = item.tittle
            tvTextContent.text = item.description
        }


    }
    private fun actionBarsup(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tittle_on2_actionbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) finish()
        return true
    }
}
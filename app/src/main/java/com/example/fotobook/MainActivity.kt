package com.example.fotobook

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fotobook.constant.Const
import com.example.fotobook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListenerClick {
    private lateinit var bind: ActivityMainBinding
    private var adapter = FhotoAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                it.data?.getSerializableExtra(Const.PHOTO_KEY, Fhoto::class.java)
                    ?.let { it1 -> adapter.addFoto(it1) }

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        bind.rcView.layoutManager = GridLayoutManager(this, 2)
        bind.rcView.adapter = adapter
        if(item.itemId == R.id.bAdd) {
            editLauncher?.launch(Intent(this, EditActivity::class.java))
        }
        return true
    }

    @SuppressLint("RestrictedApi")
    override fun onClick(fhoto: Fhoto) {
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra(Const.ITEM, fhoto)
        })
        }
    }


package com.example.popupmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.popupmenuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

    }

    fun popupShow(v: View) {
        val popUp = PopupMenu(this,v)

        popUp.setOnMenuItemClickListener(this@MainActivity)
        popUp.menuInflater.inflate(R.menu.actions,popUp.menu)


//        val inflater = popUp.menuInflater
//        inflater.inflate(R.menu.actions, popUp.menu)
        popUp.show()

    }

    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        return when(p0?.itemId) {
            R.id.filter -> {
                Toast.makeText(this, "필터 선택", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.favorite -> {
                Toast.makeText(this, "즐겨찾기 선택", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }

    }


}
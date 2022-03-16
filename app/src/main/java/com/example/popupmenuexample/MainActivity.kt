package com.example.popupmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.popupmenuexample.databinding.ActivityMainBinding

typealias DC = DataClass
class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private val array = listOf(DC(5L,"ABCV"),DC(4L,"ACCC"), DC(123L, "QWER"), DC(456L,"ZZZ") )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val adapter = Adapter()
        binding.listView.adapter = adapter

        adapter.submitList(array)

        //1.컨텍스트메뉴에 view 등록
        registerForContextMenu(binding.contextMenuBtn)
        //registerForContextMenu(binding.listView)

    }

    fun popupShow(v: View) {
        val popUp = PopupMenu(this, v)

        popUp.setOnMenuItemClickListener(this@MainActivity)
        popUp.menuInflater.inflate(R.menu.actions, popUp.menu)

//        val inflater = popUp.menuInflater
//        inflater.inflate(R.menu.actions, popUp.menu)
        popUp.show()

    }

    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        return when (p0?.itemId) {
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


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.delete_item -> {
                Toast.makeText(this, "삭제를 선택했습니다.", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.edit_item -> {
                Toast.makeText(this, "편집을 선택했습니다.", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.detail_item -> {
                Toast.makeText(this, "상세정보를 선택했습니다.", Toast.LENGTH_SHORT).show()
                true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
}
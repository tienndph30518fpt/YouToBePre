package com.duytien.youtobepre.setting

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.duytien.youtobepre.R
import com.duytien.youtobepre.adapter_item_setting.MemoryItemAdapter
import com.duytien.youtobepre.adapter_item_setting.PlayerItemAdapter
import com.duytien.youtobepre.adapter_item_setting.SystemItemAdapter
import com.duytien.youtobepre.model_item_seting.Memory
import com.duytien.youtobepre.model_item_seting.Player_setting
import com.duytien.youtobepre.model_item_seting.System_Setting

class SettingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlayerItemAdapter
    private lateinit var adapterSys: SystemItemAdapter
    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerMemory: RecyclerView
    private lateinit var adapterMemory: MemoryItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerMemory = findViewById(R.id.recycler_memory)
        recyclerView = findViewById(R.id.recyclerPlayer)
        recyclerView1 = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerMemory.layoutManager = LinearLayoutManager(this)
        val itemPlayer = listOf(

            Player_setting("Quản lý", false),
            Player_setting("Chế độ ban đêm", true),
            Player_setting("Tự động phát", true),

            )
        val itemSystem = listOf(
            System_Setting("Chủ đề", "Chế độ tối"),
            System_Setting("Ngôn ngữ", "Tiếng Việt"),
            System_Setting("Vị trí", "Việt Nam")

        )
        val itemMemory = listOf(
            Memory("Xóa bộ nhớ đệm")
        )

        adapterSys = SystemItemAdapter(itemSystem)
        adapterMemory = MemoryItemAdapter(itemMemory)
        adapter = PlayerItemAdapter(itemPlayer)

        recyclerView1.adapter = adapterSys
        recyclerView.adapter = adapter
        recyclerMemory.adapter = adapterMemory
    }
}
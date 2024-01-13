package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ChatBoard: AppCompatActivity() {

    private lateinit var lastChatRc: RecyclerView
    private lateinit var lastChatList: List<LastChatHistoryModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen_add_new_chat)

    }
}
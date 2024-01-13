package com.example.myapplication

import ChatAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Chat : AppCompatActivity() {

    private lateinit var messageAdapter: ChatAdapter
    private lateinit var chatRc: RecyclerView
    private var chatMessageList = mutableListOf<MessageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_layout)

        // Inicjalizacja RecyclerView
        chatRc = findViewById(R.id.chatRecyclerView)
        chatRc.layoutManager = LinearLayoutManager(this)
        messageAdapter = ChatAdapter(this, chatMessageList)
        chatRc.adapter = messageAdapter

        // Przykładowe dane
        val senderUser = User("SenderUsername","idk")
        val receiverUser = User("ReceiverUsername","idk")

        val senderMessage1 = MessageModel("Hello", senderUser, System.currentTimeMillis(), isSender = true)
        val receiverMessage1 = MessageModel("Hi", receiverUser, System.currentTimeMillis())

        val senderMessage2 = MessageModel("How are you?", senderUser, System.currentTimeMillis(), isSender = true)
        val receiverMessage2 = MessageModel("I'm good, thanks!", receiverUser, System.currentTimeMillis())

        // Dodanie danych do listy wiadomości
        chatMessageList.add(senderMessage1)
        chatMessageList.add(receiverMessage1)
        chatMessageList.add(senderMessage2)
        chatMessageList.add(receiverMessage2)

        // Poinformowanie adaptera o zmianach w danych
        messageAdapter.notifyDataSetChanged()
    }
}

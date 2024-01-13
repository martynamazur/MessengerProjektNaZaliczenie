package com.example.myapplication
data class MessageModel(
    var message: String?,
    var sender: User,
    var createdAt: Long,
    var isSender: Boolean = false
)


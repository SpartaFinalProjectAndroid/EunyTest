package com.example.eunytest.data.model

import com.example.eunytest.data.api.AI_MODEL
import com.google.gson.JsonObject

data class AiRequest(
    val model: String = AI_MODEL,
    val messages: List<Message>
)
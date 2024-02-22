package com.example.eunytest.data.repository

import android.util.Log
import com.example.eunytest.data.model.AiRequest
import com.example.eunytest.data.model.AiResponse
import com.example.eunytest.data.model.Message
import com.example.eunytest.data.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AiRepository {
    suspend fun createChatCompletion(message: String): AiResponse = withContext(Dispatchers.IO) {
        val request = AiRequest(messages = listOf(Message("user", message)))
        Log.d("Connect ChatGPT", "2. Ai Repository")
        RetrofitInstance.aiApi.createChatCompletion(request)

    }
}
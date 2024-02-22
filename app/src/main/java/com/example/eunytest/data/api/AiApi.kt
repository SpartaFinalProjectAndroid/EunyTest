package com.example.eunytest.data.api

import com.example.eunytest.data.model.AiRequest
import com.example.eunytest.data.model.AiResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val AI_API_KEY = "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"
const val AI_MODEL = "gpt-3.5-turbo"

interface AiApi {
    @Headers("Authorization: Bearer $AI_API_KEY")
    @POST("chat/completions")

    suspend fun createChatCompletion(@Body body: AiRequest) : AiResponse
}
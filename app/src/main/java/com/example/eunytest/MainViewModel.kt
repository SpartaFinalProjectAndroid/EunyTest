package com.example.eunytest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eunytest.data.MainUiState
import com.example.eunytest.data.repository.AiRepository
import kotlinx.coroutines.launch

class MainViewModel(private val aiRepo: AiRepository = AiRepository()) : ViewModel() {



    private var _mainUiState = MutableLiveData<MainUiState>()

    val mainUiState : LiveData<MainUiState> = _mainUiState
    fun checkAiApi(text: String) {




        viewModelScope.launch {
            kotlin.runCatching {
                val text1 = "등산 정보에 대해 알려줘"
                Log.d("Connect ChatGPT", "^^ 1. ViewModel")
                val channelResponse = aiRepo.createChatCompletion(text1).choices.first().message.content

                _mainUiState.value = MainUiState(response = channelResponse)

            }.onSuccess {
                Log.d("Connect ChatGPT","^^Successful!")
            }.onFailure {
                Log.d("Connect ChatGPT","^^Failed!")

            }
        }

    }
}
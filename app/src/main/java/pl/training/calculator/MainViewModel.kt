package pl.training.calculator

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.util.UUID

class MainViewModel : ViewModel() {

    val messages = mutableStateListOf<String>()

    fun addMessage() {
        messages.add(UUID.randomUUID().toString())
    }

}
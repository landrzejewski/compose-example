package pl.training.compseexamples

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import java.util.UUID

class Model : ViewModel() {

    val messages = mutableStateListOf<String>()

    fun addMessage() {
        messages.add(UUID.randomUUID().toString())
    }

}
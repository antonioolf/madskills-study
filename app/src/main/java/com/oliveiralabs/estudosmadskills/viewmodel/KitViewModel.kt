package com.oliveiralabs.estudosmadskills.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oliveiralabs.estudosmadskills.model.Kit
import com.oliveiralabs.estudosmadskills.service.KitService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KitViewModel : ViewModel() {

    private val _kits = MutableStateFlow<List<Kit>>(emptyList())
    val kits: StateFlow<List<Kit>> get() = _kits

    private val kitService = KitService.create()

    init {
        fetchKits()
    }

    private fun fetchKits() {
        viewModelScope.launch {
            try {
                val fetchedKits = kitService.getKits()
                _kits.value = fetchedKits
            } catch (e: Exception) {
                // Trate a exceção
            }
        }
    }
}

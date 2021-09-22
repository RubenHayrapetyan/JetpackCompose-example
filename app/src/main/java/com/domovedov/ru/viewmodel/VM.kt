package com.domovedov.ru.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VM: ViewModel() {

    private val _state: MutableLiveData<Boolean> = MutableLiveData(true)

    val state: LiveData<Boolean> get() = _state

    fun setState(status: Boolean) {
        _state.postValue(status)
    }

}
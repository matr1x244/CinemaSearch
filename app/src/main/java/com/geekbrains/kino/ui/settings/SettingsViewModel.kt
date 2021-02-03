package com.geekbrains.kino.ui.settings

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val TAG = "SettingsViewModel"

    private val _text = MutableLiveData<String>().apply {
        value = "5.0"
    }
    val text: LiveData<String> = _text
}
package com.domovedov.ru.ui.home.stories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.domovedov.ru.data.services.TimerService
import com.domovedov.ru.helpers.BaseViewModel

class StoriesViewModel(
    private val timerService: TimerService
): BaseViewModel() {

    private val _bottomNavBar by lazy { MutableLiveData(true) }
    val bottomNavBar: LiveData<Boolean> get() = _bottomNavBar

    fun setBottomNavBar(isShown: Boolean){
        _bottomNavBar.value = isShown
    }

    fun vvv(){
        Log.i("vsdvav", "Yes")
    }
    private val _seconds = MutableLiveData(0L)
    val seconds: LiveData<Long> = _seconds

    val timer: LiveData<Long> = timerService.timer
    val isTimerFinished: LiveData<Boolean> = timerService.isTimerFinished

    fun startAndInitTimer(seconds: Long){
        timerService.startTimer(seconds)
    }

    fun stopTimer(){
        timerService.stopTimer()
    }
}
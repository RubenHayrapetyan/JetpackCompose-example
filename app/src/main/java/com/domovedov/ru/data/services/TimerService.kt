package com.domovedov.ru.data.services

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TimerService {

    private lateinit var timerDown: CountDownTimer

    private val _timer: MutableLiveData<Long> by lazy { MutableLiveData<Long>() }
    val timer: LiveData<Long> = _timer

    private val _timerIsFinished: MutableLiveData<Boolean> = MutableLiveData(false)
    val isTimerFinished: LiveData<Boolean> = _timerIsFinished

    private var milliseconds = 0L
    private var timerIsStopped = true
    private var timerIsRunning = false
    private val tenSeconds = 10 * 1000L

    fun timerIsRunning(): Boolean = timerIsRunning

    private fun initCountDownTimer() {
        timerDown = object : CountDownTimer(tenSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timer.value = millisUntilFinished
                milliseconds = millisUntilFinished
                _timerIsFinished.value = false
            }

            override fun onFinish() {
                _timerIsFinished.value = true
                milliseconds = 0L
            }
        }
    }

    fun setMilliseconds(milliseconds: Long) {
        this.milliseconds = milliseconds
    }

    fun getMilliseconds(): Long {
        return milliseconds
    }

    fun startTimer() {
        initCountDownTimer()
        if (this::timerDown.isInitialized) {
            if (timerIsStopped) {
                timerDown.start()
                timerIsStopped = false
                timerIsRunning = true
            }
        }
    }

    fun stopTimer() {
        if (this::timerDown.isInitialized) {
            timerDown.cancel()
            timerIsStopped = true
            timerIsRunning = false
        }
    }
}
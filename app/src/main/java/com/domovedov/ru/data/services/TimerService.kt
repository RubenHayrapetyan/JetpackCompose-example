package com.domovedov.ru.data.services

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TimerService {

    private lateinit var timerUp: CountDownTimer

    private val _timer: MutableLiveData<Long> by lazy { MutableLiveData<Long>() }
    val timer: LiveData<Long> = _timer

    private val _timerIsFinished: MutableLiveData<Boolean> = MutableLiveData(false)
    val isTimerFinished: LiveData<Boolean> = _timerIsFinished

    private var milliseconds = 0L
    private var timerIsStopped = true
    private var timerIsRunning = false
//    private val tenSeconds = 10 * 1000L

    fun timerIsRunning(): Boolean = timerIsRunning

    private fun initCountUpTimer(seconds: Long) {
        val intervalSeconds: Long = 1

        timerUp = object : CountDownTimer(seconds * 1000 , intervalSeconds ) {
            override fun onTick(millisUntilFinished: Long) {
                _timer.value = (seconds * 1000 - millisUntilFinished)
            }

            override fun onFinish() {
                _timerIsFinished.value = true
            }
        }
    }

    fun setMilliseconds(milliseconds: Long) {
        this.milliseconds = milliseconds
    }

    fun getMilliseconds(): Long {
        return milliseconds
    }

    fun startTimer(seconds: Long) {
        initCountUpTimer(seconds)
        if (this::timerUp.isInitialized) {
            if (timerIsStopped) {
                timerUp.start()
                timerIsStopped = false
                timerIsRunning = true
            }
        }
    }

    fun stopTimer() {
        if (this::timerUp.isInitialized) {
            timerUp.cancel()
            timerIsStopped = true
            timerIsRunning = false
        }
    }
}
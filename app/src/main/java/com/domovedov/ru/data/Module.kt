package com.domovedov.ru.data

import com.domovedov.ru.data.services.TimerService
import org.koin.dsl.module

val serviceModule = module {
    single { TimerService() }
}
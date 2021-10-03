package com.domovedov.ru.ui.home.configurator

import com.domovedov.entities.local.DeliveryLocalModel
import com.domovedov.entities.local.FacadeLocalModel
import com.domovedov.entities.local.FoundationLocalModel

val foundationList = listOf(
    FoundationLocalModel(
        1, "Буронабивные сваи",
        "Способ забивки свай,который состоит из бурения " +
                "скважины. Способ забивки свай, который состоит из бурения ",
        3000,
        true
    ),
    FoundationLocalModel(
        2, "Буронабивные сваи", "Способ забивки свай, который " +
                "состоит из бурения скважины. Способ забивки свай, который состоит" +
                " из бурения ",
        3000,
        false
    ),
    FoundationLocalModel(
        3, "Foundation 3", "Description 3",
        1000,
        false
    ),
)

val facadeList = listOf(
    FacadeLocalModel(
        1,  "Декоративные панели",
        "Практичные виниловые панели, имитирующие природные материа лыимитирующие природные ",
        3000,
        true
    ),
    FacadeLocalModel(
        2, "Буронабивные сваи", "Способ забивки свай, который " +
                "состоит из бурения скважины. Способ забивки свай, который состоит" +
                " из бурения ",
        3000,
        false
    ),
    FacadeLocalModel(
        3, "Foundation 3", "Description 3",
        1000,
        false
    ),
)

val deliveryList = listOf(
    DeliveryLocalModel(
        1, "До участка",
        "Доставка материалов до вашего участка. Разгрузка включена в стоимость. " +
                "Разгрузка включена в стоимость цены",
        3000,
        true
    ),
    DeliveryLocalModel(
        2, "Буронабивные сваи", "Способ забивки свай, который " +
                "состоит из бурения скважины. Способ забивки свай, который состоит" +
                " из бурения ",
        3000,
        false
    ),
    DeliveryLocalModel(
        3, "Foundation 3", "Description 3",
        1000,
        false
    ),
)
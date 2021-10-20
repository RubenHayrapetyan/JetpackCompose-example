package com.domovedov.ru

import com.domovedov.entities.local.*
import com.domovedov.ru.ui.home.picturesList

val multicoloredCardLocalModel = listOf(
    MulticoloredCardLocalModel(
        "Подготовка к строительству",
        "Сформируем этапность работ, " +
                "проверим земельный участок, а также подскажем как подготовиться к строительству.",
        "https://image.freepik.com/free-photo/pink-background_23-2148162976.jpg",
        true
    ),
    MulticoloredCardLocalModel(
        "Строительство",
        "Застройщик произведет домокомплект, а после соберет на вашем участке. " +
                "Мы в свою очередь будем выезжать на стройку чтобы контролировать работы и проверять " +
                "качество материалов.",
        "https://cdn.wallpapersafari.com/22/49/Y4lP9G.jpg",
        true
    ),
    MulticoloredCardLocalModel(
        "Завершение",
        "Выполним регистрационные процедуры в Росреестре, а также будем на связи по всем " +
                "вопросам, которые могут возникнуть при эксплуатации.",
        "https://media.istockphoto.com/vectors/dreamy-smooth-abstract-green-background" +
                "-vector-id1248543636?b=1&k=20&m=1248543636&s=170667a&w=0&h=yf3caBfotGWM1ONXJPeBOfA1IdVz8TbEvwwvTZKXmW8=",
        false
    )
)

val peculiaritiesList = listOf(
    PeculiaritiesLocalModel(
        "Технология фахверк",
        "Удобный и уютный одноэтажный дом с надежной двускатной крышей надежной двускатной"
    ),
    PeculiaritiesLocalModel(
        "Технология фахверк 2",
        "Удобный и уютный одноэтажный дом с надежной двускатной крышей надежной двускатной 222"
    ),
    PeculiaritiesLocalModel(
        "Технология фахверк 3",
        "Удобный и уютный одноэтажный дом с надежной двускатной крышей надежной двускатной  333"
    ),
)

val storiesList = listOf(
    StoriesFullScreenModel(
        "Экспертиза строительных работ",
        "Гнилые доски, дырявые стены, токсичные материалы, обрушение конструкций",
        picturesList[0], 10f
    ),
    StoriesFullScreenModel(
        "Экспертиза строительных работ 2",
        "Гнилые доски, дырявые стены 2, токсичные материалы, обрушение конструкций",
        picturesList[1], 10f
    ),
    StoriesFullScreenModel(
        "Экспертиза строительных работ 3",
        "Гнилые доски, дырявые стены 3, токсичные материалы, обрушение конструкций",
        picturesList[2], 10f
    ),
    StoriesFullScreenModel(
        "Экспертиза строительных работ 4",
        "Гнилые доски, дырявые стены 4, токсичные материалы, обрушение конструкций",
        picturesList[3], 10f
    )
)

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
        1, "Декоративные панели",
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

val description =
    "Удеобный и уютный одноэтажный дом с надежной двускатной крышей из битумной черепицы. " +
            "Оригинальный экстерьер идеально отвечает современной планировке функционального строения. " +
            "Оригинальный экстерьер идеально отвечает современной планировке функционального строения."
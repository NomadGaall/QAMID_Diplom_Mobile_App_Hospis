# Дипломный проект профессии «Инженер по тестированию»

## Предварительные условия:

1. Установить и открыть Android Studio

`https://developer.android.com/studio`

2. Склонировать репозиторий

`https://github.com/NomadGaall/QAMID_Diplom_Mobile_App_Hospis`

3. Установить приложение "Мобильный хоспис" на мобильное устройство.

4. Данные для авторизации:

- В поле "Логин" ввести: login2

- В поле "Пароль" ввести: password2

---
## Инструкция по запуску
1. Перейти в файл в для проверки тестирования:

```fmh_android_15_03_24/app/src/androidTest/java/ru/iteco/fmhandroid/ui```


2. В терминале выполнить команду:

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AuthorizationTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AboutTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.MainTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.NewsControlPanelTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.NewsTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```$ adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.ThematicQuoteTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```
## Документация

1. [План автоматизации тестирования]()

2. [Чек-лист]()

3. [Тест-кейсы]()

<h1 >Проект автоматизации API для сайта <a href="https://reqres.in/ ">reqres.in</a></h1>

## Содержание

* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Автоматизированные проверки</a>
* <a href="#console">Запуск тестов</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>

<a id="tools"></a>
## Технологии и инструменты

<p  align="center">

<code><img width="5%" title="IntelliJ IDEA" src="media/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="media/logo/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="media/logo/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="media/logo/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="media/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="media/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="media/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="media/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="media/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="media/logo/Jenkins_logo.svg"></code>
<code><img width="5%" title="Jira" src="media/logo/Jira.svg"></code>
<code><img width="5%" title="Telegram" src="media/logo/Telegram.svg"></code>
</p>

Автотесты написаны на `Java` с использованием `JUnit 5` и `Gradle`.

Краткий список интересных фактов о проекте:
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Custom Allure listener для API requests/responses логов
- [x] Cборка в `Jenkins`
- [x] Формирование Allure-отчета
- [x] Интеграция с `Allure TestOps`
- [x] Отправка уведомления с результатами в `Telegram`

<a id="cases"></a>
## Автоматизированные проверки
:heavy_check_mark: Checking a negative registration case

:heavy_check_mark: User update check

:heavy_check_mark: Checking Id when creating a user

:heavy_check_mark: Checking the data of one specific user

:heavy_check_mark: User deletion check

<a id="console"></a>
##  Запуск тестов

```
gradle clean api_test 
```

<a id="jenkins"></a>
## Запуск тестов в <a target="_blank" href="https://jenkins.autotests.cloud/job/017_Guzel_Uz_api_reqresin_tests/"> Jenkins </a>

<p align="center">
<img src="images/screenshots/JenkinsJob.PNG"/>
</p>

<a id="allure"></a>
## Отчеты в <a target="_blank" href="https://jenkins.autotests.cloud/job/017_Guzel_Uz_api_reqresin_tests/2/allure/"> Allure report </a>

### Основное окно

<p align="center">
<img src="images/screenshots/AllureOverview.png">
</p>

### Тесты

<p align="center">
<img src="images/screenshots/AllureBehaviors.png">
</p>

<a id="testops"></a>
## Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/2181/dashboards"> Allure TestOps </a>

### Доска
<p align="center">
<img src="images/screenshots/AllureTestOpsDashboard.PNG">
</p>

<a id="telegram"></a>
## Уведомления в Telegram с использованием бота

<p>
<img src="images/screenshots/TelegramBot.PNG">
</p>


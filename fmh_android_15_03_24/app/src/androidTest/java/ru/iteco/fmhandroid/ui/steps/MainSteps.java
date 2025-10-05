package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;



import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AuthorizationPage;
import ru.iteco.fmhandroid.ui.elements.MainPage;

public class MainSteps {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    public void mainScreenLoad() {
        Allure.step("Загрузка страницы");
        onView(isRoot()).perform(waitDisplayed(mainPage.allNews, 5000));
    }

    public void checkThatMainBlockContentIsFull() {
        Allure.step("Проверка, что в блоке \"Главная\" полный контент");
        authorizationPage.getAuthorizationElementsButtonExit.check(matches(isDisplayed()));
        mainPage.getMainElementsButtonMainMenu.check(matches(isDisplayed()));
        mainPage.getMainElementsOurMissionButton.check(matches(isDisplayed()));
        mainPage.getMainElementsTitleNews.check(matches(isDisplayed()));
        mainPage.getMainElementsAllNewsButton.check(matches(isDisplayed()));
    }


    public void waitingForMaiMenbToLoad() {
        Allure.step("Ожидание загрузки  главный экран и появится меню");
        // Ждем пока загрузится главный экран и появится меню
        onView(isRoot()).perform(waitDisplayed(getMainMenuButton(), 5000));
    }
    public void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главного меню");
        mainPage.getMainElementsButtonMainMenu
                .perform(click());
    }

    public void clickButtonMain() {
        Allure.step("Нажать на кнопку Главная в Главном меню");
        mainPage.getMainElementsButtonMain
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step("Нажать на кнопку Свернуть/развернуть ВСЕ НОВОСТИ на Главной странице");
        mainPage.getMainElementsButtonToRollUpAllNews
                .perform(click());
    }


    public void showTitleNewsOnMain() {
        Allure.step(" Отобразилась панель Новости (News)");
        mainPage.getMainElementsTitleNews
                .check(matches(isDisplayed()));
    }
    public void waitingTextNews() {
        Allure.step("Ожидание текста \"News\"");
        onView(withText("News")).check(matches(isDisplayed()));
    }
    public void DisplayingAllNews() {
        Allure.step("Отображение \"ALL NEWS\" ");
        mainPage.getMainElementsButtonAllNews.check(matches(withText("ALL NEWS")));
    }
    public void DisplayingGetButtonToExpandNews() {
        onView(isRoot()).perform(waitDisplayed(getButtonToExpandNews(), 5000));
    }


    public int getMainMenuButton() {
        return mainPage.mainMenuButton;
    }

    public int getButtonToExpandNews() {
        return mainPage.buttonToExpandNews;
    }
}
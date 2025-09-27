package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;



import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Новости\" (News) мобильного приложения \"Мобильный хоспис\".")
public class NewsTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();


    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainSteps.mainScreenLoad();
        } catch (Exception e) {
            authorizationSteps.fillLoginField(getLogin());
            authorizationSteps.fillPasswordField(getPassword());
            authorizationSteps.clickButtonSignIn();
            mainSteps.mainScreenLoad();
        }
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "Новости" (News) мобильного приложения "Мобильный хоспис".

    //  NC - 1 - Сортировка новостей во вкладке"Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("NC - 1")
    @Description(" Переход во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void transferToAllNewsThroughMainMenu() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
        newsSteps.buttonSortingControlPanel();
        newsSteps.buttonSortingControlPanel();
    }
    //  NC - 2 - Сортировка новостей по несуществующей дате  во вкладке"Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("NC - 2")
    @Description(" Сортировка новостей по несуществующей дате во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void FilterToAllNewsThroughMainMenu() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
        newsSteps.buttonFilterControlPanel();
        newsSteps.startDateFilter();
        newsSteps.endDateFilter();
        newsSteps.canselfilterbutton();
        newsSteps.isEmptyNewsList();

    }

    //  NC - 3 - Сортировка новостей с отменой фильтрации во вкладке"Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("NC - 3")
    @Description(" Сортировка новостей с отменой фильтрации во вкладку Все новости (ALL NEWS) через главное меню мобильного приложения Мобильный хоспис (Позитивный).")
    public void FilterWithCanselToAllNewsThroughMainMenu() {
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
        newsSteps.buttonFilterControlPanel();
        newsSteps.startDateFilter();
        newsSteps.canselfilterbutton();

    }
}

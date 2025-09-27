package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.NewsPage;
import ru.iteco.fmhandroid.ui.data.TestUtils;
import androidx.test.espresso.ViewInteraction;


public class NewsSteps {

    NewsPage newsPage = new NewsPage();

    public void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости в Главном меню");
        newsPage.getNewsButton
                .perform(click());
    }
    public void openNewsOnNewsPage(int position) {
        Allure.step("Открыть новость");
        TestUtils.waitView(TestUtils.withRecyclerView(newsPage.listNews)
                .atPositionOnView(position, newsPage.newsItemMaterial)).perform(click());
    }
    public ViewInteraction getNewsItemDescription(int position) {
        Allure.step("");
        return TestUtils.waitView(TestUtils.withRecyclerView(newsPage.listNews).atPositionOnView(position, newsPage.newsItemDescription));
    }
    public void buttonSortingControlPanel() {
        Allure.step("Нажать кнопку смены порядка отображения новостей (стрелочки)");
        newsPage.buttonSortingControlPanel
                .perform(click());
    }
    public void buttonFilterControlPanel() {
        Allure.step("Нажать кнопку фильтрации");
        newsPage.buttonFilterControlPanel
                .perform(click());
    }

    public void startDateFilter() {
        Allure.step("Вставка даты начала");
        newsPage.startDateFilter.perform(replaceText(newsPage.localdatetoday));

    }
    public void endDateFilter() {
        Allure.step("Вставка даты окончания");
        newsPage.endDateFilter.perform(replaceText(newsPage.localdatetomorrow));

    }
    public void hefilterbutton() {
        Allure.step("Нажать кнопку Filter");
        newsPage.buttonFilter.perform(click());;

    }
    public void canselfilterbutton() {
        Allure.step("Нажать кнопку Cansel");
        newsPage.buttonCanselFilter.perform(click());;

    }

    public void isEmptyNewsList() {
        Allure.step("Проверка на отсутвие новостейl");
        TestUtils.waitView(withId(R.id.empty_news_list_image_view)).check(matches(isDisplayed()));
        TestUtils.waitView(withText("There is nothing here yet…")).check(matches(isDisplayed()));
        TestUtils.waitView(allOf(withId(R.id.news_retry_material_button), withText("REFRESH"))).check(matches(isDisplayed()));
    }

}

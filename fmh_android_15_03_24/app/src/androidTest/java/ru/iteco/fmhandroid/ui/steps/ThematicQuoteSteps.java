package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ThematicQuotePage;

public class ThematicQuoteSteps {

    ThematicQuotePage thematicQuotePage = new ThematicQuotePage();
    public void checkThatQuotesBlockContentIsFull() {
        Allure.step("Проверка, что в блоке с цитатами полный контент");
        thematicQuotePage.logo.check(matches(isDisplayed()));
        thematicQuotePage.title.check(matches(isDisplayed()));
        thematicQuotePage.ourMissionList.check(matches(isDisplayed()));
    }


    public void clickButtonThematicQuote() {
        Allure.step("На главной странице экрана приложения нажать на кнопку Бабочка (Тематические цитаты).");
        thematicQuotePage.getQuoteElementButtonThematicQuote
                .perform(click());
    }

    public void checkTitleThematicQuote() {
        Allure.step("Проверить заголовок Love is all на вкладке Тематические цитаты.");
        thematicQuotePage.getQuoteElementTitleThematicQuote
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public void clickButtonToExpandThematicQuote() {
        Allure.step("Нажать на кнопку развернуть тематическую цитату.");
        thematicQuotePage.getQuoteElementButtonToExpandThematicQuote
                .perform(click());
    }

    public int getMissionImageButton() {
        return thematicQuotePage.missionImageButton;
    }
}

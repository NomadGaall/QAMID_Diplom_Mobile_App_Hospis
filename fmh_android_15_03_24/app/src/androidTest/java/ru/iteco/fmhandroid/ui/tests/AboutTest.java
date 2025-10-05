package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\".")
public class AboutTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    AboutSteps aboutSteps = new AboutSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public IntentsTestRule<AppActivity> intentsTestRule =
            new IntentsTestRule<>(AppActivity.class);

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

    @After
    public void tearDown() {
        try {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
        } catch (Exception ignored) {
        }
    }

    //  AP - 1 - Корректность отображения всех элементов экрана About "О приложении" (About) мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("AP - 1 ")
    @Description("Корректность отображения всех элементов экрана (About)\"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void shouldBeFullContentInAboutBlock() {
        mainSteps.waitingForMaiMenbToLoad();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.checkThatAboutBlockContentIsFull();
        pressBack();
    }

    //  AP - 2 - Просмотр ссылки "Политика конфиденциальности" (Privacy policy) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис"(Позитивный).
    @Test
    @Story("AP - 2 ")
    @Description("Просмотр ссылки \"Политика конфиденциальности\" (Privacy policy) во вкладке \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный)")
    public void watchingPrivacyPolicy() {
        mainSteps.waitingForMaiMenbToLoad();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonPrivacyPolicy();
        aboutSteps.returnToTheApp();
        pressBack();
    }

    //  AP - 3 - Просмотр ссылки "Пользовательское соглашение"  (Terms of use) во вкладке "О приложении" (About) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("AP - 3")
    @Description("Просмотр ссылки \"Пользовательское соглашение\"  (Terms of use) во вкладке \"О приложении\" (About) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void watchingTermsOfUse() {
        mainSteps.waitingForMaiMenbToLoad();
        mainSteps.clickButtonMainMenu();
        aboutSteps.clickButtonAboutMainMenu();
        aboutSteps.clickButtonTermsOfUse();
        aboutSteps.returnToTheApp();
        pressBack();
    }
}
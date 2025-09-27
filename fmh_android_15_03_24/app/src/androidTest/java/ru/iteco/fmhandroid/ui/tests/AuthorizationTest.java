package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getEmptyField;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLoginWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getOneLetterLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getOneLetterPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPasswordWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getUnregisteredLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getUnregisteredPassword;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.After;
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

@LargeTest
@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Авторизация\" мобильного приложения \"Мобильный хоспис\".")
public class AuthorizationTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.loadAuthorizationPage();
        } catch (
                Exception e) {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
            authorizationSteps.loadAuthorizationPage();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void tearDown() {
        try {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
        } catch (Exception ignored) {
        }
    }

// Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" (Authorization) мобильного приложения "Мобильный хоспис".

    //  AC - 1,2,3 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
    @Test
    @Story("AC - 1,2,3")
    @Description("Авторизация в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void Authorizationsuccessful() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
        mainSteps.showTitleNewsOnMain();
        authorizationSteps.clickButtonExit();
        authorizationSteps.clickButtonLogOut();
    }


    //  AC - 8 -  Поле "Логин" (Login) и "Пароль" (Password)заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 8")
    @Description("Поле \"Логин\" (Login) и \"Пароль\" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void bothFieldsWithUnregisteredCredentials() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUnregisteredLogin());
        authorizationSteps.fillPasswordField(getUnregisteredPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  AC - 9 - Поле "Пароль" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("TC - 8")
    @Description("Поле \"Пароль\" (Password) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void validLoginWithUnregisteredPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getUnregisteredPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
    //  AC - 10 -  Поле "Логин" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 10")
    @Description("Поле \"Логин\" (Login) заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void unregisteredLoginWithValidPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getUnregisteredLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  AC - 11 - Поле "Логин" (Login) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 11")
    @Description("Поле \"Логин\" (Login) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void emptyLoginWithValidPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getEmptyField());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
 
    //  AC - 12 - Поле "Пароль" (Password) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 12")
    @Description("Поле \"Пароль\" (Password) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void validLoginWithEmptyPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getEmptyField());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    //  AC - 13 -Поле  "Логин" (Login) и "Пароль" (Password) пустое, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
        @Test
        @Story("TC - 7")
        @Description("Поле \"Пароль\" (Password) пустое, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
        public void bothFieldsEmpty() {
            onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
            authorizationSteps.textAuthorization();
            authorizationSteps.fillLoginField(getEmptyField());
            authorizationSteps.fillPasswordField(getEmptyField());
            authorizationSteps.clickButtonSignIn();
            onView(withText("Login and password cannot be empty"))
                    .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                    .check(matches(isDisplayed()));
    }

    // AC - 14 Поле "Логин" (Login) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 14")
    @Description("Поле \"Логин\" (Login) состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void singleCharacterLoginWithValidPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getOneLetterLogin());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }

    // AC - 15  Поле "Пароль" (Password) состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 15")
    @Description("Поле \"Пароль\" (Password)  состоит из одного символа, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void validLoginWithSingleCharacterPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getOneLetterPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }    

    //  AC - 16 - Поле "Логин" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 16")
    @Description("Поле \"Логин\" (Login) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void loginWithSpecialCharactersWithValidPassword() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLoginWithSpecialCharacters());
        authorizationSteps.fillPasswordField(getPassword());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
        //  AC - 17 - Поле "Пароль" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис" (Негативный).
    @Test
    @Story("AC - 17")
    @Description("Поле \"Пароль\" (Password) состоит из спецсимволов, при авторизации, в мобильном приложении \"Мобильный хоспис\" (Негативный).")
    public void validLoginWithPasswordWithSpecialCharacters() {
        onView(isRoot()).perform(waitDisplayed(authorizationSteps.getLoginLayout(), 5000));
        authorizationSteps.textAuthorization();
        authorizationSteps.fillLoginField(getLogin());
        authorizationSteps.fillPasswordField(getPasswordWithSpecialCharacters());
        authorizationSteps.clickButtonSignIn();
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
}

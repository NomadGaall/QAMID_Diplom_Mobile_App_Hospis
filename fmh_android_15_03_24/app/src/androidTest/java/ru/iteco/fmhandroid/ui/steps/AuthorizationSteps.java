package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.differentRegexLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.differentRegexPassword;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.emptyField;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.loginWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.loginwithspaces;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.oneLetterLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.oneLetterPassword;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.onlySpaces;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.passwordWithSpecialCharacters;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.passwordwithspaces;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.rightLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.rightPassword;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.unregisteredLogin;
import static ru.iteco.fmhandroid.ui.elements.AuthorizationPage.unregisteredPassword;





import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.AuthorizationPage;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AuthorizationPage;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    public ActivityTestRule<AppActivity> activityRule =
            new ActivityTestRule<>(AppActivity.class);

    public void loadAuthorizationPage() {
        Allure.step("Загрузка страницы авторизации");
        onView(isRoot()).perform(waitDisplayed((authorizationPage.enterButton), 5000));
    }
    public void clickButtonSignIn() {
        Allure.step("Нажать на кнопку Войти");
        authorizationPage.getAuthorizationElementsButton
                .perform(click());
    }

    public void clickButtonExit() {
        Allure.step("Нажать на кнопку Выход");
        authorizationPage.getAuthorizationElementsButtonExit
                .perform(click());
    }

    public void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        authorizationPage.getAuthorizationElementsButtonLogOut
                .perform(click());
    }

    public void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        authorizationPage.getAuthorizationElementsTextAuthorization
                .check(matches(isDisplayed()));
    }

    public void fillLoginField(String text) {
        Allure.step("Поле Логин - ввод данных" + text);
        authorizationPage.getAuthorizationElementsLoginField.perform(replaceText(text));
    }

    public void fillPasswordField(String text) {
        Allure.step("Поле Пароль - ввод данных" + text);
        authorizationPage.getAuthorizationElementsPasswordField.perform(replaceText(text));
    }

    public void waitingAuthorizationPageAndLoginLayout() {
        onView(isRoot()).perform(waitDisplayed(getLoginLayout(), 5000));
    }
    public void waitForAuthorizationButton() {
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 3000));
    }
    // ... существующий код ...

    /**
     * Ожидание и проверка сообщения "Something went wrong. Try again later."
     * @param decorView Декоративный View активности
     */
    public void waitForSomethingWentWrong(View decorView) {
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
    /**
     * Ожидание и проверка сообщения "Login and password cannot be empty"
      @param decorView Декоративный View активности
     */
    public void waitForEmptyLoginOrPasswordError(View decorView) {
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }


    public static String getLogin() {
        return rightLogin;
    }

    public static String getPassword() {
        return rightPassword;
    }


    public static String getUnregisteredLogin() {
        return unregisteredLogin;
    }

    public static String getLoginWithSpecialCharacters() {
        return loginWithSpecialCharacters;
    }

    public static String getEmptyField() {
        return emptyField;
    }    

    public static String getOneLetterLogin() {
        return oneLetterLogin;
    }

    public static String getUnregisteredPassword() {
        return unregisteredPassword;
    }

    public static String getPasswordWithSpecialCharacters() {
        return passwordWithSpecialCharacters;}

    public static String getOneLetterPassword() {
        return oneLetterPassword;
    }

    public int getLoginLayout() {
        return authorizationPage.loginLayout;
    }

}

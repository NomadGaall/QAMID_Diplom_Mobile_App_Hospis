package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AboutPage;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static ru.iteco.fmhandroid.ui.data.DataHelper.elementWaiting;
import androidx.test.uiautomator.UiDevice;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.Until;

import ru.iteco.fmhandroid.R;




public class AboutSteps {
    AboutPage aboutPage = new AboutPage();

    public void clickButtonAboutMainMenu() {
        Allure.step("Нажать кнопку О приложении (About) в Главном меню");
        aboutPage.getABoutElementButtonAbout
                .perform(click());
    }

    public void checkThatAboutBlockContentIsFull() {
        Allure.step("Проверка, что в блоке \"О приложении\" полный контент");
        elementWaiting(withId(R.id.about_company_info_label_text_view), 5000);
        aboutPage.logo.check(matches(isDisplayed()));
        aboutPage.backButton.check(matches(isDisplayed()));
        aboutPage.versionTitleField.check(matches(isDisplayed()));
        aboutPage.versionNumberField.check(matches(isDisplayed()));
        aboutPage.policyText.check(matches(isDisplayed()));
        aboutPage.termsOfUseText.check(matches(isDisplayed()));
        aboutPage.infoCompany.check(matches(isDisplayed()));
        aboutPage.privacyPolicyValue.check(matches(isDisplayed()));
        aboutPage.termsOfUseValue.check(matches(isDisplayed()));
    }

    public void clickButtonPrivacyPolicy() {
        Allure.step(" Нажать на ссылку Политика конфиденциальности (Privacy policy).");
        aboutPage.privacyPolicyValue
                .perform(click());
    }

    public void clickButtonTermsOfUse() {
        Allure.step("Нажать на ссылку Пользовательское соглашение (Terms of use).");
        aboutPage.termsOfUseValue
                .perform(click());
    }
    private UiDevice device;

    public AboutSteps() {
        this.device = UiDevice.getInstance(getInstrumentation());
    }

    public void returnToTheApp() {
        try {
            // Ждем открытия браузера (Chrome)
            device.wait(Until.hasObject(By.pkg("com.android.chrome")), 10000);

            // Нажимаем системную кнопку "Назад"
            device.pressBack();

            // Ждем возврата в приложение
            device.wait(Until.hasObject(By.pkg("ru.iteco.fmhandroid")), 5000);

        } catch (Exception e) {
            // Если что-то пошло не так, пробуем альтернативные варианты
            try {
                device.pressBack(); // Просто нажимаем назад
                Thread.sleep(2000); // Ждем немного
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

}


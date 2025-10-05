package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getLogin;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.getPassword;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryBirthday;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getCategoryUnion;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionBirthdayEdit;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getDescriptionSalary;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategory;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategoryDescription;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getSpecialCharactersCategoryTitle;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleAdvertisement;
import static ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps.getTitleBirthdayEdit;


import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Flaky;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования \"Панели управления\" (Control panel) новостей мобильного приложения \"Мобильный хоспис\".")
public class NewsControlPanelTest {
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    NewsControlPanelSteps newsControlPanelSteps = new NewsControlPanelSteps();

    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

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
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

        //  СP - 1 - Переход во вкладку "Все новости" (ALL NEWS) через вкладку "Главная страница" (Main) мобильного приложения "Мобильный хоспис" (Позитивный)
    @Test
    public void testShowAllNewsThroughMainPage() {

        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.checkThatControlPanelContentIsFull();


    }
        //  СP - 2 - Сортировка новостей во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("СP - 2")
    @Description("Сортировка новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void sortingNewsOmControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.createNewsForTest();
        newsControlPanelSteps.clickButtonSortingNews();
        newsControlPanelSteps.thedisplayordechangesfromtheearliest();
        newsControlPanelSteps.clickButtonSortingNews();
        newsControlPanelSteps.thedisplayordechangesfromthlateste();

    }

//  CP-3 - Проверка чек-боксов Фильтра новостей/Filter News "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Flaky
    @Story("СP - 3")
    @Description("Сортировка новостей во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void testFilteringNewsStatusActiveControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickthenewsfilterbutton();
        newsControlPanelSteps.clickcheckboxstatusActive();
        newsControlPanelSteps.checkBoxStatusActive(false);;
        newsControlPanelSteps.clickcheckboxstatusNotActive();
        newsControlPanelSteps.NcheckBoxStatuspActive(false);;
        newsControlPanelSteps.clickcheckboxstatusActive();
        newsControlPanelSteps.checkBoxStatusActive(true);;
        newsControlPanelSteps.clickcheckboxstatusNotActive();
        newsControlPanelSteps.NcheckBoxStatuspActive(true);;

    }

    //  CP-4 - Фильтрация новостей по критерию "Активна", во вкладке "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    public void testFilteringNewsStatusNotActiveControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickthenewsfilterbutton();
        newsControlPanelSteps.clickcheckboxstatusNotActive();
        newsControlPanelSteps.NcheckBoxStatuspActive(false);;
        newsSteps.hefilterbutton();
        newsControlPanelSteps.verifyAllNewsHaveStatus("ACTIVE");
        newsControlPanelSteps.clickthenewsfilterbutton();
        newsControlPanelSteps.clickcheckboxstatusActive();
        newsSteps.hefilterbutton();
        newsControlPanelSteps.verifyAllNewsHaveStatus("NOT ACTIVE");
    }
    ViewInteraction categoryText = onView(
            withId(R.id.news_item_category_text_auto_complete_text_view));

    //  CP - 5 -  Отмена фильтрации новостей через  "Панель управления" (Control panel) новостей мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("CP - 5")
    @Description("Отмена фильтрации новостей через во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void testFilteringNewsCancelingTheNewsFilterControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickthenewsfilterbutton();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryUnion());
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryUnion());
        newsSteps.canselfilterbutton();
        newsControlPanelSteps.checkThatControlPanelContentIsFull();
    }

    //  CP - 6 - Создание активной новости с категорией "Объявление" во вкладке "Панели управления" (Control panel) в мобильном приложении "Мобильный хоспис" (Позитивный).
    @Test
    @Story(" CP - 6")
    @Description("Создание активной новости с категорией \"Объявление\" во вкладке \"Панели управления\" (Control panel) в мобильном приложении \"Мобильный хоспис\" (Позитивный).")
    public void creationNewsInControlPaneAdvertisement() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryAdvertisement());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleAdvertisement());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionSalary());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonSortingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        newsControlPanelSteps.availabilityForTextAdvanceIsListed();
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();

    }

        //  CP-7 - Поле "Категория" (Category) состоит из спецсимволов, при создании новости, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("CP-7")
    @Description("Поле \"Категория\" (Category) состоит из спецсимволов, при создании новости, во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Негативный).")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.fillInNewsCategoryField(getSpecialCharactersCategory());
        newsControlPanelSteps.fillTitleCreatingNews(getSpecialCharactersCategoryTitle());
        newsControlPanelSteps.clickButtonDateCreatingNextDate();
        newsControlPanelSteps.clickButtonTimeCreatingNews();
        newsControlPanelSteps.clickButtonOkTimeCreatingNews();
        newsControlPanelSteps.fillDescriptionCreatingNews(getSpecialCharactersCategoryDescription());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.waitingErrorsSavingFaileds(decorView);
        pressBack();
    }

    //  CP - 8 - Создание новости с пустыми полями, во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Негативный).
    @Test
    @Story("CP - 8")
    @Description("Создание новости с пустыми полями, во вкладке \"Панель управления\" (Control panel) мобильного приложения Мобильный хоспис (Негативный).")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickAddNews();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.waitingErrorsWithEmptyFields(decorView);
        pressBack();

    }

        //  CP - 11 - Смена статуса новости, находящейся в статусе "АКТИВНА" (Active), на статус "НЕ АКТИВНА" (Not active), во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("CP - 11")
    @Description("Смена статуса новости, находящейся в статусе \"АКТИВНА\" (Active), на статус \"НЕ АКТИВНА\" (Not active), во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void changingStatusNewsControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.clickButtonToSwitchStatusNews();
        newsControlPanelSteps.availabilityForTextANotActive();
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.waitingNewsWithStatuseNotActive();
        newsControlPanelSteps.clickButtonToDeleteNews();
        newsControlPanelSteps.clickButtonToOkDeleteNews();
    }
    
        
    //  CP - 12 - Редактирование новости во вкладке "Панель управления" (Control panel) мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @Story("CP - 12")
    @Description("Редактирование новости во вкладке \"Панель управления\" (Control panel) мобильного приложения \"Мобильный хоспис\" (Позитивный).")
    public void editingNewsControlPanel() {
        newsControlPanelSteps.shouldOpenCreateNews();
        newsControlPanelSteps.clickButtonControlPanel();
        newsControlPanelSteps.clickButtonToEditNews();
        newsControlPanelSteps.fillInNewsCategoryField(getCategoryBirthday());
        newsControlPanelSteps.fillTitleCreatingNews(getTitleBirthdayEdit());
        newsControlPanelSteps.fillDescriptionCreatingNews(getDescriptionBirthdayEdit());
        newsControlPanelSteps.clickButtonSaveCreatingNews();
        newsControlPanelSteps.clickButtonToExpandNews();
        newsControlPanelSteps.availabilityForTextAanniversary();
        pressBack();
    }

}

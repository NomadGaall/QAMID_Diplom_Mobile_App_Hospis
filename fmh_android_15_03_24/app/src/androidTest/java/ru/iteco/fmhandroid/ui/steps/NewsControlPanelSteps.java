package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryBirthday;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryCelebration;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categorySalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.categoryUnion;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.customCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionBirthday;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionBirthdayEdit;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionGratitudeDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionSalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.descriptionUnion;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.numbersCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategoryDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.specialCharactersCategoryTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleAdvertisement;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleBirthdayEdit;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleCelebration;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleGratitude;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleGratitudeDonations;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleNeedHelp;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleSalary;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleSalaryEnumerated;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.titleUnion;

import android.view.View;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;


public class NewsControlPanelSteps {

    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();

    public void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonControlPanel
                .perform(click());
    }
    public void clickcheckboxstatusActive() {
        Allure.step("Нажать на чек бокс Активна");
        newsControlPanelPage.inAtiveCheckBox
                .perform(click());
    }
    public void clickcheckboxstatusNotActive() {
        Allure.step("Нажать на чек бокс Не Активна");
        newsControlPanelPage.inNoActiveCheckBox
                .perform(click());
    }
    public void checkBoxStatusActive(boolean checked) {
        Allure.step("Проверка нажатия - Active");

        if (checked) {
            newsControlPanelPage.inAtiveCheckBox.check(matches(isChecked()));
        } else {
            newsControlPanelPage.inAtiveCheckBox.check(matches(isNotChecked()));
        }
    }
    public void NcheckBoxStatuspActive(boolean checked) {
        Allure.step("Проверка нажатия - NpActive");

        if (checked) {
            newsControlPanelPage.inNoActiveCheckBox.check(matches(isChecked()));
        } else {
            newsControlPanelPage.inNoActiveCheckBox.check(matches(isNotChecked()));
        }
    }


    public void thedisplayordechangesfromtheearliest() {
        Allure.step("Порядок отображения новости от самой ранней");
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("10.10.2025")));
    }
    public void thedisplayordechangesfromthlateste() {
        Allure.step("Порядок отображения новости от самой поздней");
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(withText("15.04.2026")));
    }
    public void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        newsControlPanelPage.getNewsControlPanelElementsAddNews
                .perform(click());
    }
    public void verifyAllNewsHaveStatus(String expectedStatus) {
        Allure.step("Проверить, что все новости имеют статус: " + expectedStatus);

        // Получаем количество новостей
        int newsCount = getNewsCount();
        Allure.step("Найдено новостей: " + newsCount);

        for (int i = 0; i < newsCount; i++) {
            final int currentIndex = i;
            Allure.step("Проверка новости №" + (currentIndex + 1));

            onView(withIndex(withId(R.id.news_item_published_text_view), currentIndex))
                    .check(matches(withText(expectedStatus)));
        }
    }

    public int getNewsCount() {
        int maxNewsCount = 10;
        int count = 0;

        for (int i = 0; i < maxNewsCount; i++) {
            try {
                onView(withIndex(withId(R.id.news_item_material_card_view), i))
                        .check(matches(isDisplayed()));
                count = i + 1;
            } catch (Exception e) {
                break;
            }
        }

        return count;
    }

    public void fillTitleCreatingNews(String text) {
        Allure.step("Ввести в поле Заголовок заголовок новости");
        newsControlPanelPage.getNewsControlPanelElementsButtonTitleCreatingNews
                .perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }


    public void clickButtonTimeCreatingNews() {
        Allure.step("В поле Время выбрать время");
        newsControlPanelPage.getNewsControlPanelElementsButtonTimeCreatingNews
                .perform(click());
    }

    public void clickButtonOkTimeCreatingNews() {
        Allure.step("Нажать кнопку ОК Время");
        newsControlPanelPage.getNewsControlPanelElementsButtonOkTimeCreatingNews
                .perform(click());
    }

    public void fillDescriptionCreatingNews(String text) {
        Allure.step("Ввести в поле Описание описание новости");
        newsControlPanelPage.getNewsControlPanelElementsDescriptionCreatingNews
                .perform(replaceText(text), closeSoftKeyboard());
    }

    public void clickButtonSaveCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        newsControlPanelPage.getNewsControlPanelElementsButtonSaveCreatingNews
                .perform(click());
//                .perform(scrollTo(), click());
    }


    public void fillInNewsCategoryField(String text) {
        Allure.step("Поле категория - ввод данных");
        newsControlPanelPage.getNewsControlPanelElementsCategoryText.perform(click(), clearText(), replaceText(text), closeSoftKeyboard());
    }

    static String nextYear = "13.03.2026";

    public void clickButtonDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(nextYear));
    }

    static String nextDate = "10.10.2025";
    public void ButtonDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать будущая дата");
        newsControlPanelPage.getNewsControlPanelElementsButtonDateCreatingNews
                .perform(replaceText(nextDate));
    }


    public void clickButtonSortingNews() {
        Allure.step("Нажать кнопку Сортировать новости в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonSortingControlPanel
                .perform(click());
    }

    public void clickButtonToExpandNews() {
        Allure.step("Нажать кнопку Развернуть новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToExpandNews
                .perform(click());
    }

    public void clickButtonToDeleteNews() {
        Allure.step("Нажать кнопку Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToDeleteNews
                .perform(click());
    }

    public void clickButtonToOkDeleteNews() {
        Allure.step("Нажать кнопку ОК Удалить новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToOkDeleteNews
                .perform(click());
    }

    public void clickButtonToEditNews() {
        Allure.step("Нажать кнопку Редактировать новость в Панели управления");
        newsControlPanelPage.getNewsControlPanelElementsButtonToEditNews
                .perform(click());
    }

    public void clickButtonToSwitchStatusNews() {
        Allure.step("Сменить статус Активная на статус Не активна (передвинуть рычажок).");
        newsControlPanelPage.getNewsControlPanelElementsButtonToSwitchStatusNews
                .perform(click());
    }
    public void checkThatControlPanelContentIsFull() {
        Allure.step("Проверка, что в панели управления полный контент");
        elementWaiting(withId(R.id.add_news_image_view), 5000);
        newsControlPanelPage.logo.check(matches(isDisplayed()));
        newsControlPanelPage.sortButton.check(matches(isDisplayed()));
        newsControlPanelPage.filterButton.check(matches(isDisplayed()));
        newsControlPanelPage.addNewsButton.check(matches(isDisplayed()));
    }
    public void clickthenewsfilterbutton() {
        Allure.step("Нажать кнопку филтр новостей).");
        newsControlPanelPage.filterButton
                .perform(click());
    }


    public void shouldOpenCreateNews() {
        Allure.step("Переход в Contro; panel).");
        onView(isRoot()).perform(waitDisplayed(mainSteps.getMainMenuButton(), 5000));
        mainSteps.clickButtonMainMenu();
        newsSteps.clickButtonNews();
        onView(allOf(withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))))).check(matches(isDisplayed()));
    }
    public void availabilityForTextAdvanceIsListed() {
        Allure.step("Порядок отображения новости от самой поздней");
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Перечислен аванс")));
    }
    public void availabilityForTextAanniversary() {
        Allure.step("Порядок отображения новости от самой поздней");
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(withText("Юбилей")));
    }
    public void availabilityForTextANotActive() {
        Allure.step("Ожидание блока с текстом \"Not active\"");
        onView(withId(R.id.switcher))
                .check(matches(withText("Not active")))
                .check(matches(isDisplayed()));
    }
    public void waitingNewsWithStatuseNotActive () {
        Allure.step("Порядок отображения новости от самой поздней");
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(withText("NOT ACTIVE")));
    }

    /**
     * Ожидание и проверка сообщения "Fill empty fields"
     @param decorView Декоративный View активности
     */
    public void waitingErrorsWithEmptyFields(View decorView) {
        onView(withText("Fill empty fields"))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
    /**
     * Ожидание и проверка сообщения "Fill empty fields"
     @param decorView Декоративный View активности
     */
    public void waitingErrorsSavingFaileds(View decorView) {
        onView(withText("Saving failed. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
                .check(matches(isDisplayed()));
    }
    public void createNewsForTest () {
        Allure.step("Создание новости");
        clickAddNews();
        fillInNewsCategoryField(getCategoryAdvertisement());
        fillTitleCreatingNews(getTitleAdvertisement());
        ButtonDateCreatingNextDate();
        clickButtonTimeCreatingNews();
        clickButtonOkTimeCreatingNews();
        fillDescriptionCreatingNews(getDescriptionSalary());
        clickButtonSaveCreatingNews();
    }



    public static String getCategoryAdvertisement() {
        return categoryAdvertisement;
    }

    public static String getTitleAdvertisement() {
        return titleAdvertisement;
    }

    public static String getDescriptionAdvertisement() {
        return descriptionAdvertisement;
    }

    public static String getCategorySalary() {
        return categorySalary;
    }

    public static String getTitleSalary() {
        return titleSalary;
    }

    public static String getDescriptionSalary() {
        return descriptionSalary;
    }

    public static String getTitleDonations() {
        return titleDonations;
    }

    public static String getDescriptionDonations() {
        return descriptionDonations;
    }

    public static String getCategoryBirthday() {
        return categoryBirthday;
    }

    public static String getDescriptionBirthday() {
        return descriptionBirthday;
    }

    public static String getTitleSalaryEnumerated() {
        return titleSalaryEnumerated;
    }

    public static String getDescriptionSalaryEnumerated() {
        return descriptionSalaryEnumerated;
    }

    public static String getCategoryUnion() {
        return categoryUnion;
    }

    public static String getTitleUnion() {
        return titleUnion;
    }

    public static String getDescriptionUnion() {
        return descriptionUnion;
    }

    public static String getCategoryCelebration() {
        return categoryCelebration;
    }

    public static String getTitleCelebration() {
        return titleCelebration;
    }

    public static String getCustomCategory() {
        return customCategory;
    }

    public static String getCustomCategoryTitle() {
        return customCategoryTitle;
    }

    public static String getCustomCategoryDescription() {
        return customCategoryDescription;
    }

    public static String getNumbersCategory() {
        return numbersCategory;
    }

    public static String getNumbersCategoryTitle() {
        return numbersCategoryTitle;
    }

    public static String getNumbersCategoryDescription() {
        return numbersCategoryDescription;
    }

    public static String getSpecialCharactersCategory() {
        return specialCharactersCategory;
    }

    public static String getSpecialCharactersCategoryTitle() {
        return specialCharactersCategoryTitle;
    }

    public static String getSpecialCharactersCategoryDescription() {
        return specialCharactersCategoryDescription;
    }

    public static String getCategoryGratitude() {
        return categoryGratitude;
    }

    public static String getTitleGratitude() {
        return titleGratitude;
    }

    public static String getDescriptionGratitude() {
        return descriptionGratitude;
    }

    public static String getCategoryNeedHelp() {
        return categoryNeedHelp;
    }

    public static String getTitleNeedHelp() {
        return titleNeedHelp;
    }

    public static String getDescriptionNeedHelp() {
        return descriptionNeedHelp;
    }

    public static String getTitleGratitudeDonations() {
        return titleGratitudeDonations;
    }

    public static String getDescriptionGratitudeDonations() {
        return descriptionGratitudeDonations;
    }

    public static String getTitleBirthdayEdit() {
        return titleBirthdayEdit;
    }

    public static String getDescriptionBirthdayEdit() {
        return descriptionBirthdayEdit;
    }
}



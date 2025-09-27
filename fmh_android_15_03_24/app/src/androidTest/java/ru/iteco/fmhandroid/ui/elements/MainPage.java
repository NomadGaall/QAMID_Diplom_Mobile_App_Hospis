package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction getMainElementsButtonMainMenu;
    public ViewInteraction getMainElementsButtonMain;
    public ViewInteraction getMainElementsButtonToRollUpAllNews;
    public ViewInteraction getMainElementsTitleNews;
    public ViewInteraction getMainElementsButtonAllNews;
    public int mainMenuButton;
    public int buttonToExpandNews;
    public int allNews;
    public int listNews;

    /// ///////////////////////////////////////
    public ViewInteraction mainLogo;

    // Выход из приложения

    public ViewInteraction logOutButton;

    // Бургерное Меню
    public ViewInteraction menuButton;
    public ViewInteraction mainOfMenu;
    public ViewInteraction newsOfMenu;
    public ViewInteraction aboutOfMenu;

    // Переход к блоку цитат о хосписе
    public ViewInteraction getMainElementsOurMissionButton;

    // Блок новостей
    public ViewInteraction getMainElementsAllNewsButton;
    public ViewInteraction collapseAllNewsButton;
    public ViewInteraction childNewsButton;

    public MainPage() {

        getMainElementsButtonMainMenu = onView(withId(R.id.main_menu_image_button));
        getMainElementsButtonMain = onView(allOf(withId(android.R.id.title), withText("Main")));
        getMainElementsButtonToRollUpAllNews = onView(withId(R.id.expand_material_button));
        getMainElementsTitleNews = onView(allOf(withText("News"), withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
        getMainElementsButtonAllNews = onView(allOf(withId(R.id.all_news_text_view), withText("ALL NEWS")));
        getMainElementsOurMissionButton = onView(withId(R.id.our_mission_image_button));
        getMainElementsAllNewsButton = onView(withId(R.id.all_news_text_view));
        mainMenuButton = R.id.main_menu_image_button;
        buttonToExpandNews = R.id.expand_material_button;
        allNews = R.id.all_news_text_view;



        mainLogo = onView(withId(R.id.trademark_image_view));
        logOutButton = onView(withText("Выйти"));
        mainOfMenu = onView(withText("Главная"));
        newsOfMenu = onView(withText("Новости"));
        aboutOfMenu = onView(withText("О приложении"));
        collapseAllNewsButton = onView(withId(R.id.expand_material_button));
    }
}

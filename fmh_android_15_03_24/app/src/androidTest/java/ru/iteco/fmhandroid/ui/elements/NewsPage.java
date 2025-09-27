package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.TestUtils;

public class NewsPage {
    public int listNews;
    public int newsItemMaterial;
    public int newsItemDescription;

    public ViewInteraction getNewsButton;
    public ViewInteraction childNewsButton;
    public ViewInteraction buttonSortingControlPanel;
    public ViewInteraction buttonFilterControlPanel;
    public ViewInteraction startDateFilter;
    public ViewInteraction endDateFilter;
    public ViewInteraction buttonFilter;
    public ViewInteraction buttonCanselFilter;
    public final String localdatetoday;
    public final String localdatetomorrow;


    public NewsPage() {
        getNewsButton = onView(allOf(withId(android.R.id.title), withText("News")));
        listNews = R.id.news_list_recycler_view;
        newsItemMaterial = R.id.news_item_material_card_view;
        newsItemDescription =R.id.news_item_description_text_view;
        buttonSortingControlPanel = onView(withId(R.id.sort_news_material_button));
        buttonFilterControlPanel = onView(withId(R.id.filter_news_material_button));
        startDateFilter = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        endDateFilter = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        buttonFilter = onView(withId(R.id.filter_button));
        buttonCanselFilter = onView(withId(R.id.cancel_button));
        LocalDateTime today = LocalDateTime.now();
        localdatetoday = TestUtils.getDateToString(today);
        localdatetomorrow = TestUtils.getDateToString(today.plus(1, ChronoUnit.DAYS));


    }


}
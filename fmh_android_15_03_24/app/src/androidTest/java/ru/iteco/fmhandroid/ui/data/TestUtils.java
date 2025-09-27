package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtils {

    public static CustomRecyclerViewActions.RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new CustomRecyclerViewActions.RecyclerViewMatcher(recyclerViewId);
    }

    public static ViewInteraction waitView(Matcher<View> matcher) {
        onView(isRoot()).perform(DataHelper.waitForElement(matcher, 10000));
        return onView(matcher);
    }

    public static String getDateToString(LocalDateTime date) {
        String formatPattern = "dd.MM.yyyy";
        return date.format(DateTimeFormatter.ofPattern(formatPattern));
    }


}

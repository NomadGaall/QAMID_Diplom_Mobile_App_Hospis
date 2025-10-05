package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class ThematicQuotePage {

    public ViewInteraction getQuoteElementButtonThematicQuote;
    public ViewInteraction getQuoteElementTitleThematicQuote;
    public ViewInteraction getQuoteElementButtonToExpandThematicQuote;
    public int missionImageButton;

    public ViewInteraction logo;
    public ViewInteraction title;
    public ViewInteraction ourMissionList;
    public ViewInteraction missionConstraintLayout;
    public ViewInteraction itemDescriptionTextView;
    public ViewInteraction getItemDescriptionTextView;


    public ThematicQuotePage() {

        getQuoteElementButtonThematicQuote = onView(withId(R.id.our_mission_image_button));
        getQuoteElementTitleThematicQuote = onView(withId(R.id.our_mission_title_text_view));
        getQuoteElementButtonToExpandThematicQuote = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
        missionImageButton = R.id.our_mission_image_button;
        logo = onView(withId(R.id.trademark_image_view));
        title = onView(withId(R.id.our_mission_title_text_view));
        ourMissionList = onView(withId(R.id.our_mission_item_list_recycler_view));
        missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
        getItemDescriptionTextView = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
    }
}
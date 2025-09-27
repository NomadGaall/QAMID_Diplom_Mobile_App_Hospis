package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    public ViewInteraction getABoutElementButtonAbout;
    public ViewInteraction logo;
    public ViewInteraction backButton;
    public ViewInteraction versionTitleField;
    public ViewInteraction versionNumberField;
    public ViewInteraction policyText;
    public ViewInteraction termsOfUseText;
    public ViewInteraction infoCompany;
    public ViewInteraction privacyPolicyValue;
    public ViewInteraction termsOfUseValue;


    public AboutPage() {
        getABoutElementButtonAbout = onView(allOf(withId(android.R.id.title), withText("About")));
        logo = onView(withId(R.id.trademark_image_view));
        backButton = onView(withId(R.id.about_back_image_button));
        versionTitleField = onView(withId(R.id.about_version_title_text_view));
        versionNumberField = onView(withId(R.id.about_version_value_text_view));
        policyText = onView(withId(R.id.about_privacy_policy_label_text_view));
        termsOfUseText = onView(withId(R.id.about_terms_of_use_label_text_view));
        infoCompany = onView(withId(R.id.about_company_info_label_text_view));
        privacyPolicyValue = onView(withId(R.id.about_privacy_policy_value_text_view));
        termsOfUseValue = onView(withId(R.id.about_terms_of_use_value_text_view));

    }
}

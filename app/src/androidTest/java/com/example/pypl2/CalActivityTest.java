package com.example.pypl2;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalActivityTest {

    @Rule
    public ActivityScenarioRule<CalendarActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(CalendarActivity.class);

    @Test
    public void calendarActivityTest() {
        //find the edittext
        onView(withId(R.id.etTest))
                .perform(typeText("paypal android"), closeSoftKeyboard());
        //type paypal anndroid into it
        //click the button
        onView(withId(R.id.button)).perform(click());
        //assert paypal android is there in the textview
        onView(withId(R.id.tvTeest))
                .check(matches(withText("paypal android")));
    }
}

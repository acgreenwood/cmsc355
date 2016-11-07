package sean.itr1;


import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ClickAddSeriesTest {
    @Rule
    public ActivityTestRule<SearchPage> SearchPageActvityTestRule = new ActivityTestRule<SearchPage>(SearchPage.class);

    //Issue: Add a series: Scenario 2: click add series
    @Test
    public void clickAddSeries() {
        Intents.init();
        onView(withId(R.id.add_new_series_button)).perform(click());
        intended(hasComponent(AddNewSeries.class.getName()));
        onView(withId(R.id.add_series_to_database)).perform(click());
        onView(withId(R.id.add_new_series_button)).check(matches(isDisplayed())); //checking to see if we are back at search page
        Intents.release();
    }
}

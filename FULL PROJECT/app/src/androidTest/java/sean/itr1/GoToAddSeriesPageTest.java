package sean.itr1;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class GoToAddSeriesPageTest {

    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<>(HomePage.class);

    //Add a series: Scenario 1: go to add series page
    @Test
    public void goToAddSeriesPage() {
        Intents.init();
        onView(withId(R.id.home_search_button)).perform(click());
        intended(hasComponent(SearchPage.class.getName()));
        onView(withId(R.id.add_new_series_button)).perform(click());
        intended(hasComponent(AddNewSeries.class.getName()));
        Intents.release();
    }
}

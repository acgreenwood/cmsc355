package sean.itr1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.*;
/**
 * Created by northwind on 10/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class HomePageTests {
    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<HomePage>(HomePage.class);

    //Issue: Search the SEAN archive: Scenario 1
    @Test
    public void pressHomeSearchButton() {
        Intents.init();
        onView(withId(R.id.home_search_button)).perform(click());
        intended(hasComponent(SearchPage.class.getName()));
        Intents.release();
    }

    //Issue: Home Page: Scenario 1
    @Test
    public void pressHomeMyArchiveButton() {
        Intents.init();
        onView(withId(R.id.my_archive_button)).perform(click());
        intended(hasComponent(MyArchivePage.class.getName()));
        Intents.release();
    }

    //Issue: Home Page: Scenario 2
    @Test
    public void pressHomeProfileButton() {
        Intents.init();
        onView(withId(R.id.profile_button)).perform(click());
        intended(hasComponent(MyProfile.class.getName()));
        Intents.release();
    }

    //Issue: Home Page: Scenario 3
    @Test
    public void pressHomeAppSettingsButton() {
        Intents.init();
        onView(withId(R.id.app_settings_button)).perform(click());
        intended(hasComponent(AppSettings.class.getName()));
        Intents.release();
    }
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

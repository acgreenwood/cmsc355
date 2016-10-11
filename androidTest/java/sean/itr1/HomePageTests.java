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

    @Test
    public void checkHomePageSearchButton() {
        onView(withId(R.id.home_search_button)).check(matches(isDisplayed()));
    }

    @Test
    public void pressHomeSearchButton() {
        Intents.init();
        onView(withId(R.id.home_search_button)).perform(click());
        intended(hasComponent(SearchPage.class.getName()));
        Intents.release();
    }

    @Test
    public void pressHomeMyArchiveButton() {
        Intents.init();
        onView(withId(R.id.my_archive_button)).perform(click());
        intended(hasComponent(MyArchivePage.class.getName()));
        Intents.release();
    }
}

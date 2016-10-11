package sean.itr1;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by northwind on 10/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class HomePageTests {
    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<HomePage>(HomePage.class);

    @Test
    public void checkHomePageSearchButton() {
        onView(withId(R.id.search_option)).check(matches(isDisplayed()));
    }

    @Test
    public void pressHomeSearchButton() {
        onView(withId(R.id.search_option)).perform(click());

    }
}

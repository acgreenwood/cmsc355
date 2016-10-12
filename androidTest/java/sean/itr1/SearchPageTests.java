package sean.itr1;

/**
 * Created by northwind on 10/10/2016.
 */
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.Espresso;
import android.view.View;
import org.hamcrest.Matcher;
import android.widget.ListView;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class SearchPageTests {
    @Rule
    public ActivityTestRule<SearchPage> SearchPageActvityTestRule = new ActivityTestRule<SearchPage>(SearchPage.class);

    //Add a series: Scenario 2
    @Test
    public void goToAddSeriesAndAdd() {
        Intents.init();
        onView(withId(R.id.add_new_series_button)).perform(click());
        onView(withId(R.id.add_series_to_database)).perform(click());
        intended(hasComponent(AddNewSeries.class.getName()));
        onView(withId(R.id.add_new_series_button)).check(matches(isDisplayed())); //checking to see if we are back at search page
        Intents.release();
    }

    //Issue: Search the SEAN archive: Scenario 2
    @Test
    public void searchTheArchive() {
        Intents.init();
        onView(withId(R.id.search_show_title)).perform(typeText(""));
        onView(withId(R.id.search_confirm_basic)).perform(click());
        intended(hasComponent(ListDisplay.class.getName()));
        onView(withId(R.id.show_list)).check(matches(isDisplayed())); //checking to see if we are at ListDisplay
        Intents.release();
        Espresso.pressBack();
    }

    //Matcher for listview size
    public static Matcher<View> withSize(final int size) {
        return new TypeSafeMatcher<View> () {
            @Override
            public void describeTo(Description description) {
                description.appendText("getChildCount should return " + size);
            }
            @Override
            protected boolean matchesSafely(View item) {
                return ((ListView) item).getCount() == size;
            }
        };
    }

    //Issue: Search the SEAN archive: Scenario 3
    @Test
    public void searchBlankTermsGetWholeArchive() {
        Intents.init();
        onView(withId(R.id.add_new_series_button)).perform(click());
        onView(withId(R.id.add_series_to_database)).perform(click());
        onView(withId(R.id.search_show_title)).perform(typeText(""));
        onView(withId(R.id.search_confirm_basic)).perform(click());
        intended(hasComponent(ListDisplay.class.getName()));
        onView(withId(R.id.show_list)).check(matches(withSize(MemoryDatabase.getArchiveSize()))); //checking to see if size of list matches size of archive
        Intents.release();
        Espresso.pressBack();
    }
}

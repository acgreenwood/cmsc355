package sean.itr1;


import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SearchBlankTermsTest {

    @Rule
    public ActivityTestRule<SearchPage> SearchPageActvityTestRule = new ActivityTestRule<SearchPage>(SearchPage.class);

    //Matcher for listview size
    public static Matcher<View> withSize(final int size) {
        return new TypeSafeMatcher<View>() {
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
    public void searchBlankTerms() {
        //onView(withId(R.id.add_new_series_button)).perform(click());
        //onView(withId(R.id.add_series_to_database)).perform(click());
        onView(withId(R.id.search_show_title)).perform(typeText(""));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.search_confirm_basic)).perform(click());

        onView(withId(R.id.show_list)).check(matches(withSize(SeriesArchiveApi.getArchiveSize()))); //checking to see if size of list matches size of archive
    }
}

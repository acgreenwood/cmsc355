package sean.itr1;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class Iteration2SortByTypeDescendingTest {
    @Rule
    public ActivityTestRule<MyArchivePage> AddSeriesActvityTestRule = new ActivityTestRule<>(MyArchivePage.class);

    // Issue: Sort My Archive: Scenario 2
    @Test
    public void sortByTypeDescendingTest() {
        onView(withId(R.id.my_archive_settings)).perform(click());

        onView(withId(R.id.type_sort)).perform(click());
        onView(withId(R.id.title_sort)).check(matches(not(isChecked())));
        onView(withId(R.id.type_sort)).check(matches(isChecked()));
        onView(withId(R.id.genre_sort)).check(matches(not(isChecked())));

        onView(withId(R.id.a_z_sort)).perform(click());
        onView(withId(R.id.a_z_sort)).check(matches(isChecked()));
        onView(withId(R.id.z_a_sort)).check(matches(not(isChecked())));

        onView(withId(R.id.save_changes_button)).perform(click());

        onView(withId(R.id.my_archive_settings)).check(matches(isDisplayed()));

        assert(MyArchiveSettings.getSortSetting() == MyArchiveSettings.Sort.TYPE);
        assert(MyArchiveSettings.getOrderSetting() == MyArchiveSettings.SortOrder.DESCENDING);
    }
}

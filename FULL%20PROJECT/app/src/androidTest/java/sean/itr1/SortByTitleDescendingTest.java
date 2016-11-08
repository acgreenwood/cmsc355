package sean.itr1;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class SortByTitleDescendingTest {
    @Rule
    public ActivityTestRule<MyArchiveSettings> myArchiveSettingsTestRule = new ActivityTestRule<>(MyArchiveSettings.class);

    @Test
    public void sortByTitleTest() {
        onView(withId(R.id.title_sort)).perform(click());
        onView(withId(R.id.title_sort)).check(matches(isChecked()));
        onView(withId(R.id.type_sort)).check(matches(not(isChecked())));
        onView(withId(R.id.genre_sort)).check(matches(not(isChecked())));
    }

    @Test
    public void sortByDescendingTest(){
        onView(withId(R.id.a_z_sort)).perform(click());
        onView(withId(R.id.a_z_sort)).check(matches(isChecked()));
        onView(withId(R.id.z_a_sort)).check(matches(not(isChecked())));
    }

    @Test
    public void pressSaveChangesButton(){
        Intents.init();
        onView(withId(R.id.save_changes_button)).perform(click());
        intended(hasComponent(MyArchivePage.class.getName()));
        Intents.release();
    }
}
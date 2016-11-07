package sean.itr1;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SearchNonExistingShowTest {

    @Rule
    public ActivityTestRule<SearchPage> SearchPageActvityTestRule = new ActivityTestRule<SearchPage>(SearchPage.class);

    //Issue: Search the SEAN archive: Scenario 4
    @Test
    public void searchNonExistingShow() {
        onView(withId(R.id.add_new_series_button)).perform(click());
        onView(withId(R.id.add_series_to_database)).perform(click());
        onView(withId(R.id.search_show_title)).perform(typeText("asdfjkl;qweruiop"));
        Espresso.closeSoftKeyboard();

        Intents.init();
        onView(withId(R.id.search_confirm_basic)).perform(click());
        intended(hasComponent(NoShowExistsWindow.class.getName()));

        Intents.release();
    }
}

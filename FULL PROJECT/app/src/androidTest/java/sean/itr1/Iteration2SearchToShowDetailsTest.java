package sean.itr1;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class Iteration2SearchToShowDetailsTest {
    @Rule
    public ActivityTestRule<HomePage> AddSeriesActvityTestRule = new ActivityTestRule<>(HomePage.class);

    // Issue: See series details: Scenario 2
    @Test
    public void searchToShowDetailsTest() {
        Intents.init();
        onView(withId(R.id.home_search_button)).perform(click());
        onView(withId(R.id.search_confirm_basic)).perform(click());
        intended(hasComponent(ListDisplay.class.getName()));
        onData(anything()).inAdapterView(withId(R.id.show_list)).atPosition(0).perform(click());
        intended(hasComponent(ShowInfo.class.getName()));
        Intents.release();
    }
}

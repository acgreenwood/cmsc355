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

public class PressHomeSearchButtonTest {

    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<>(HomePage.class);

    //Issue: Search the SEAN archive: Scenario 1
    @Test
    public void pressHomeSearchButton() {
        Intents.init();
        onView(withId(R.id.home_search_button)).perform(click());
        intended(hasComponent(SearchPage.class.getName()));
        Intents.release();
    }
}

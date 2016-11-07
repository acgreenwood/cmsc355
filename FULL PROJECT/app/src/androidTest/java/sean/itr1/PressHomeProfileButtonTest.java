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

public class PressHomeProfileButtonTest {

    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<>(HomePage.class);

    //Issue: Home Page: Scenario 2
    @Test
    public void pressHomeProfileButton() {
        Intents.init();
        onView(withId(R.id.profile_button)).perform(click());
        intended(hasComponent(MyProfile.class.getName()));
        Intents.release();
    }
}

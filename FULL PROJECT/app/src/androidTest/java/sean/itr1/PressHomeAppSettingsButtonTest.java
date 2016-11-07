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

public class PressHomeAppSettingsButtonTest {

    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<>(HomePage.class);

    //Issue: Home Page: Scenario 3
    @Test
    public void pressHomeAppSettingsButton() {
        Intents.init();
        onView(withId(R.id.app_settings_button)).perform(click());
        intended(hasComponent(AppSettings.class.getName()));
        Intents.release();
    }
}

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

public class PressHomeMyArchiveButtonTest {

    @Rule
    public ActivityTestRule<HomePage> homePageActvityTestRule = new ActivityTestRule<>(HomePage.class);

    //Issue: Home Page: Scenario 1
    @Test
    public void pressHomeMyArchiveButton() {
        Intents.init();
        onView(withId(R.id.my_archive_button)).perform(click());
        intended(hasComponent(MyArchivePage.class.getName()));
        Intents.release();
    }
}

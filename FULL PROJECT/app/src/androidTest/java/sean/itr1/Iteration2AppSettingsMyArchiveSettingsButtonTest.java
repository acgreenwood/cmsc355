package sean.itr1;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class Iteration2AppSettingsMyArchiveSettingsButtonTest {
    @Rule
    public ActivityTestRule<AppSettings> AddSeriesActvityTestRule = new ActivityTestRule<>(AppSettings.class);

    @Test
    public void appSettingsMyArchiveSettingsButtonTest() {
        Intents.init();
        onView(withId(R.id.my_archive_settings)).perform(click());
        intended(hasComponent(MyArchiveSettings.class.getName()));
        Intents.release();
    }
}

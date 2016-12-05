package sean.itr1;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class Iteration3MyArchiveSettingsCancelAlertTest {
    @Rule
    public ActivityTestRule<AppSettings> AddSeriesActvityTestRule = new ActivityTestRule<>(AppSettings.class);

    // Issue: AlertDialog when cancelling my archive settings changes: Scenario 1
    @Test
    public void myArchiveSettingsCancelAlertNoTest() {
        onView(withId(R.id.my_archive_settings)).perform(click());
        onView(withId(R.id.cancel_changes_button)).perform(click());
        onView(withText("Leave Archive Settings? All unsaved changes will be lost.")).check(matches(isDisplayed()));
    }
}

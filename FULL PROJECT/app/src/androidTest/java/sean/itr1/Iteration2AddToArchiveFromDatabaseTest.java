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
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;

@RunWith(AndroidJUnit4.class)
public class Iteration2AddToArchiveFromDatabaseTest {
    @Rule
    public ActivityTestRule<HomePage> AddSeriesActvityTestRule = new ActivityTestRule<>(HomePage.class);

    // Issue: Add a Series to Personal Archive: Scenario 3
    @Test
    public void AddToArchiveFromDatabaseTest() {
        Intents.init();
        onView(withId(R.id.database_button)).perform(click());
        intended(hasComponent(ListDisplay.class.getName()));

        MyArchive.removeSeries(0);

        onData(hasToString(startsWith("Title: Stranger"))).inAdapterView(withId(R.id.show_list)).atPosition(0).perform(click());
        intended(hasComponent(ShowInfo.class.getName()));

        onView(withId(R.id.add_remove_archive)).perform(click());

        assert (MyArchive.inMyArchive(0));

        Intents.release();
    }
}

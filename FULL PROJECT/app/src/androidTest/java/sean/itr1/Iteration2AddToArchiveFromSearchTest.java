package sean.itr1;


import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;

public class Iteration2AddToArchiveFromSearchTest {
    @Rule
    public ActivityTestRule<SearchPage> AddSeriesActvityTestRule = new ActivityTestRule<>(SearchPage.class);

    // Issue: Add a Series to Personal Archive: Scenario 2
    @Test
    public void addToArchiveFromSearchTest() {
        Intents.init();
        onView(withId(R.id.search_confirm_basic)).perform(click());
        intended(hasComponent(ListDisplay.class.getName()));

        MyArchive.removeSeries(0);

        onData(hasToString(startsWith("Title: Stranger"))).inAdapterView(withId(R.id.show_list)).atPosition(0).perform(click());
        intended(hasComponent(ShowInfo.class.getName()));

        onView(withId(R.id.add_remove_archive)).perform(click());

        assert(MyArchive.inMyArchive(0));

        Intents.release();
    }
}

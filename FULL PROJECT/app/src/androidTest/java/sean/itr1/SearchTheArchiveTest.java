package sean.itr1;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SearchTheArchiveTest {
    @Rule
    public ActivityTestRule<SearchPage> SearchPageActvityTestRule = new ActivityTestRule<SearchPage>(SearchPage.class);

    //Issue: Search the SEAN archive: Scenario 2
    @Test
    public void searchTheArchive() {
        Intents.init();
        onView(withId(R.id.search_show_title)).perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.search_confirm_basic)).perform(click());
        intended(hasComponent(ListDisplay.class.getName()));
        onView(withId(R.id.show_list)).check(matches(isDisplayed())); //checking to see if we are at ListDisplay
        Intents.release();
    }
}

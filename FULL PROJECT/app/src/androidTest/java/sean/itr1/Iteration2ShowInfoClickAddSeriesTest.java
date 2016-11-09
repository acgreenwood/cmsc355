package sean.itr1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class Iteration2ShowInfoClickAddSeriesTest {
    @Rule
    public ActivityTestRule<ShowInfo> ShowInfoActvityTestRule = new ActivityTestRule<ShowInfo>(ShowInfo.class);


    //Issue: Add a series: Senario 2: add series to database
    @Test
    public void removeSeriesFromDatabase() {
        int archiveSize = SeriesArchiveApi.getArchiveSize();
        onView(withId(R.id.add_remove_archive)).perform(click());
        assertEquals(SeriesArchiveApi.getArchiveSize(), archiveSize + 1); //check to see if archive grew in size
    }
}

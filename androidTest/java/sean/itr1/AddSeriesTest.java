package sean.itr1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.*;

/**
 * Created by northwind on 10/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class AddSeriesTest {
    @Rule
    public ActivityTestRule<AddNewSeries> AddSeriesActvityTestRule = new ActivityTestRule<AddNewSeries>(AddNewSeries.class);


    //Issue: Add a series: Senario 3: add series to database
    @Test
    public void addSeriesToDatabase() {
        int archiveSize = SeriesArchiveAPI.getArchiveSize();
        onView(withId(R.id.series_name_edit_text)).perform(typeText("qwertyui"));
        onView(withId(R.id.series_type_edit_text)).perform(typeText("movie"));
        onView(withId(R.id.series_genre_edit_text)).perform(typeText("action"));
        onView(withId(R.id.add_series_to_database)).perform(click());
        assertEquals(SeriesArchiveAPI.getArchiveSize(), archiveSize + 1); //check to see if archive grew in size
        assert(SeriesArchiveAPI.searchByTerms("qwertyui").length >= 1); // check to see if searching for the title returns at least one result
    }
}

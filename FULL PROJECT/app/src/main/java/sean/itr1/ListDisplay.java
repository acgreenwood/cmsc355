package sean.itr1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay extends Activity {
    // Array of shows
    String[] showArray; //= {...};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_display);

        listView = (ListView) findViewById(R.id.show_list);
        Series[] series = SeriesArchiveAPI
                .searchByTerms(getIntent().getExtras().getString("SEARCH_TERMS"));

        showArray = new String[series.length];
        for (int i = 0; i < series.length; i++) {
            showArray[i] = "Title: " + series[i].getTitle()
                         + "\nType: " + series[i].getType()
                         + "\nGenre: " + series[i].getGenre() + "\n";

        }
        //array at end of method is array from which data is drawn for list
        ArrayAdapter adapter
                = new ArrayAdapter<>(this, R.layout.activity_listview, showArray);

        listView.setAdapter(adapter);
    }
}
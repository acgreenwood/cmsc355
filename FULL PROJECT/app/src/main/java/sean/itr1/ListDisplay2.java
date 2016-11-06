package sean.itr1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay2 extends Activity {
    // Array of shows
    String[] showArray; //= {...};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_display);

        listView = (ListView) findViewById(R.id.show_list);
        Series[] series = SeriesArchiveAPI.searchByTerms(getIntent().getExtras().getString("SEARCH_TERMS"));

        showArray = new String[series.length];
        for(int i = 0; i < series.length; i++) {
            showArray[i] = "Title: " + series[i].getTitle() +
                         "\nType: " + series[i].getType() +
                         "\nGenre: " + series[i].getGenre() + "\n";

        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, showArray); //array at end of method is array from which data is drawn for list

        listView.setAdapter(adapter);
    }
}
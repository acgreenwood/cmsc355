package sean.itr1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay extends Activity {
    // Array of shows
    String[] showArray; //= {...};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);

        Series[] series = SeriesArchiveAPI.searchByTerms(getIntent().getExtras().getString("Search Terms"));

        showArray = new String[series.length];
        for(int i = 0; i < series.length; i++) {
            showArray[i] = "Title: " + series[i].getTitle() +
                            "\nType: " + series[i].getType() +
                            "\nGenre: " + series[i].getGenre() +
                            "\n";

        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, showArray); //array at end of method is array from which data is drawn for list

        ListView listView = (ListView) findViewById(R.id.show_list);
        listView.setAdapter(adapter);
    }
}
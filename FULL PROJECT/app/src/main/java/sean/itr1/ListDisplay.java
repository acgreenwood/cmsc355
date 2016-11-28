package sean.itr1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay extends Activity implements OnItemClickListener {
    // Array of shows
    String[] showArray; //= {...};
    ListView listView;
    Series[] series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_display);

        listView = (ListView) findViewById(R.id.show_list);
        listView.setOnItemClickListener(this);

        series = SeriesArchiveApi.searchByTerms(getIntent().getExtras().getString("SEARCH_TERMS"));

        showArray = new String[series.length];
        for (int i = 0; i < series.length; i++) {
            showArray[i] = "Title: " + series[i].getTitle()
                         + "\nType: " + series[i].getType()
                         + "\nGenre: " + series[i].getGenre(); //+ "\n";

        }
        //array at end of method is array from which data is drawn for list
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, showArray);

        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ShowInfo.class);
        Series seriesAtPos = series[position];
        intent.putExtra("id", seriesAtPos.getId());
        startActivity(intent);
    }
}
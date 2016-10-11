package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDisplay2 extends Activity {
    // Array of shows
    String[] showArray; //= {...};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Series[] series = SeriesArchiveAPI.searchByTerms(getIntent().getExtras().getString("Search Terms")+"");
        System.out.println(getIntent().getExtras().getString("Search Terms"));
        showArray = new String[series.length];
        for(int i = 0; i < series.length; i++) {
            showArray[i] = series[i].getTitle();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, showArray); //array at end of method is array from which data is drawn for list

        ListView listView = (ListView) findViewById(R.id.show_list);
        listView.setAdapter(adapter);
    }
}
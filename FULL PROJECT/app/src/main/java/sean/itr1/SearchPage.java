/*
 * Search page, which is where users can choose to search for a
 * (potentially) existing show or add a new one into the app's database.
 */

package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchPage extends AppCompatActivity {

    Button search;
    Button addNewSeries;
    Button returnHome;
    TextView searchTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        searchTerms = (TextView)findViewById(R.id.search_show_title);
        //"Search" button
        search = (Button)findViewById(R.id.search_confirm_basic);
        //"Add A New Series" button.
        addNewSeries = (Button)findViewById(R.id.add_new_series_button);
        //"Return to Home Page" button.
        returnHome = (Button)findViewById(R.id.return_home_button);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.search_confirm_basic) {
            System.out.println("prepare for failure");
            if (SeriesArchiveApi.searchByTerms(searchTerms.getText().toString()).length == 0) {
                Intent search = new Intent(this, NoShowExistsWindow.class);
                startActivity(search);
            } else {
                Intent search = new Intent(this, ListDisplay.class);
                search.putExtra("SEARCH_TERMS", searchTerms.getText().toString());
                startActivity(search);
            }
        } else if (choice.getId() == R.id.add_new_series_button) {
            Intent createNewSeries = new Intent(this, AddNewSeries.class);
            startActivity(createNewSeries);
        } else if (choice.getId() == R.id.return_home_button) {
            Intent returnHome = new Intent(this, HomePage.class);
            startActivity(returnHome);
        }
    }
}

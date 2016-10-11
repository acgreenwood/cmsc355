/*
 * This is the main activity of the Android app, which is where users can choose to search for a
 * (potentially) existing show or add a new one into the app's database.
 */

package sean.itr1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class SearchPage extends AppCompatActivity {


    Button search,addNewSeries,returnHome;
    TextView searchTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        searchTerms = (TextView)findViewById(R.id.search_show_title);
        search = (Button)findViewById(R.id.search_confirm_basic);        //"Search" button
        addNewSeries = (Button)findViewById(R.id.add_new_series_button); //"Add A New Series" button.
        returnHome = (Button)findViewById(R.id.return_home_button);      //"Return to Home Page" button.
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.search_confirm_basic){
            System.out.println("prepare for failure");
            //System.out.println(SeriesArchiveAPI.searchByTerms("").length);
            if (SeriesArchiveAPI.searchByTerms(searchTerms.getText().toString()).length == 0) {
                Intent search = new Intent(this, NoShowExistsWindow.class);
                startActivity(search);    //If selected, app searches its database for the series name. Currently no form of database exists, so it should bring users to the NoShowExistsWindow xml.
            }
            else {
                Intent search = new Intent(this, ListDisplay2.class);
                //search.putExtra("Search Results", SeriesArchiveAPI.searchByTerms(searchTerms.getText().toString())); //this string may need to be changed
                search.putExtra("Search Terms", searchTerms.getText().toString()); // testing purposes
                startActivity(search);
            }
        }

        else if (choice.getId() == R.id.add_new_series_button){
            Intent createNewSeries = new Intent(this, AddNewSeries.class);
            startActivity(createNewSeries);    //If selected, brings user to the series creation screen (specified as activity_add_new_series.xml/AddNewSeries.class).
        }

        else if (choice.getId() == R.id.return_home_button){
            Intent returnHome = new Intent(this, HomePage.class);
            startActivity(returnHome);    //If selected, brings user to the series creation screen (specified as activity_add_new_series.xml/AddNewSeries.class).
        }
    }
}

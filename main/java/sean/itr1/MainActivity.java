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

public class MainActivity extends AppCompatActivity {


    Button search,addNewSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (Button)findViewById(R.id.search_confirm_basic);        //"Search" button
        addNewSeries = (Button)findViewById(R.id.add_new_series_button); //"Add A New Series" button.
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.search_confirm_basic){
            Intent search = new Intent(this, NoShowExistsWindow.class);
            startActivity(search);    //If selected, app searches its database for the series name. Currently no form of database exists, so it should bring users to the NoShowExistsWindow xml.
        }

        else if (choice.getId() == R.id.add_new_series_button){
            Intent createNewSeries = new Intent(this, AddNewSeries.class);
            startActivity(createNewSeries);    //If selected, brings user to the series creation screen (specified as activity_add_new_series.xml/AddNewSeries.class).
        }
    }
}

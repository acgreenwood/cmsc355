/*
 * This is the window displayed for when a user wishes to add a new series into SEAN's database
 */

package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewSeries extends AppCompatActivity {

    Button addSeries,cancelAddition;
    EditText seriesName, seriesType, seriesGenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_series);
        addSeries = (Button)findViewById(R.id.confirm_addition_button);            //Confirm button to add series into app database
        cancelAddition = (Button)findViewById(R.id.decline_addition_button);       //Returns user to MainActivity window
        seriesName = (EditText)findViewById(R.id.series_name_edit_text);
        seriesType = (EditText)findViewById(R.id.series_type_edit_text);
        seriesGenre = (EditText)findViewById(R.id.series_genre_edit_text);
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.add_series_to_database){
            SeriesArchiveAPI.addSeries(new Series(0, seriesName.getText().toString(), seriesType.getText().toString(), seriesGenre.getText().toString()));
            finish(); //If selected, adds series into the app database (not yet implemented atm: DO NOT CLICK UNTIL IT IS IMPLEMENTED INTO THE APP CODE).
        }

        else if (choice.getId() == R.id.cancel_action){
            Intent returnToSearch = new Intent(this, SearchPage.class);
            startActivity(returnToSearch);      //If selected, returns user to MainActivity window. (Test to see if the click does accomplish the specified action)
        }
    }
}

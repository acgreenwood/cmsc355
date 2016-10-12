/*
 * This java class is for the window to display if the app fails to find the name of a show
 * the user enters in the search bar when it looks over the database
 */

package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoShowExistsWindow extends AppCompatActivity {

    Button confirm,deny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_show_exists_window);

        confirm = (Button)findViewById(R.id.confirm_addition_button);    //Confirm button to move to the series creation window
        deny = (Button)findViewById(R.id.decline_addition_button);       //Deny button to return back to main window
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.confirm_addition_button){
            Intent createNewSeries = new Intent(this, AddNewSeries.class);
            startActivity(createNewSeries);    //If found, sends user to the series addition window at the AddNewSeries class.
        }

        else if (choice.getId() == R.id.decline_addition_button){
            Intent returnToMain = new Intent(this, SearchPage.class);
            startActivity(returnToMain);      //If selected, returns user to MainActivity window.
        }
    }
}

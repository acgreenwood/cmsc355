package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    Button search, database, myArchive, settings, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        search = (Button)findViewById(R.id.home_search_button);        //"Search" button
        database = (Button)findViewById(R.id.database_button);
        myArchive = (Button)findViewById(R.id.my_archive_button);         //"Add A New Series" button.
        settings = (Button)findViewById(R.id.app_settings_button);    //"App Settings" button.
        profile = (Button)findViewById(R.id.profile_button);      //"Profile" button
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.home_search_button){
            Intent search = new Intent(this, SearchPage.class);
            startActivity(search);    //If selected, app searches its database for the series name. Currently no form of database exists, so it should bring users to the NoShowExistsWindow xml.
        }

        else if (choice.getId() == R.id.database_button){
            Intent database = new Intent(this, ListDisplay.class);
            startActivity(database);
            
            /*
             * Note: This button currently does not work at the moment, and WILL crash the app if pressed. 
             * Look into getting that fixed after changes to ListDisplay are done.
             */
        }

        else if (choice.getId() == R.id.my_archive_button){
            Intent myArchive = new Intent(this, MyArchivePage.class);
            startActivity(myArchive);    //If selected, brings user to the series creation screen (specified as activity_add_new_series.xml/AddNewSeries.class).
        }

        else if (choice.getId() == R.id.app_settings_button){
            Intent appSettings = new Intent(this, AppSettings.class);
            startActivity(appSettings);    //If selected, brings user to the series creation screen (specified as activity_add_new_series.xml/AddNewSeries.class).
        }

        else if (choice.getId() == R.id.profile_button){
            Intent myProfile = new Intent(this, MyProfile.class);
            startActivity(myProfile);    //If selected, brings user to the series creation screen (specified as activity_add_new_series.xml/AddNewSeries.class).
        }
    }
}


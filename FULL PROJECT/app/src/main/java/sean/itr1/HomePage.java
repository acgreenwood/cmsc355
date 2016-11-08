package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button search;
    Button database;
    Button myArchive;
    Button settings;
    Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        search = (Button)findViewById(R.id.home_search_button); //"Search" button
        database = (Button)findViewById(R.id.database_button);  //"Database" button
        myArchive = (Button)findViewById(R.id.my_archive_button); //"Add A New Series" button
        settings = (Button)findViewById(R.id.app_settings_button); //"App Settings" button
        profile = (Button)findViewById(R.id.profile_button); //"Profile" button
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.home_search_button) {
            Intent search = new Intent(this, SearchPage.class);
            startActivity(search);
        } else if (choice.getId() == R.id.database_button) {
            Intent database = new Intent(this, ListDisplay.class);
            database.putExtra("SEARCH_TERMS", "");
            startActivity(database);
        } else if (choice.getId() == R.id.my_archive_button) {
            Intent myArchive = new Intent(this, MyArchivePage.class);
            startActivity(myArchive);
        } else if (choice.getId() == R.id.app_settings_button) {
            Intent appSettings = new Intent(this, AppSettings.class);
            startActivity(appSettings);
        } else if (choice.getId() == R.id.profile_button) {
            Intent myProfile = new Intent(this, MyProfile.class);
            startActivity(myProfile);
        }
    }
}


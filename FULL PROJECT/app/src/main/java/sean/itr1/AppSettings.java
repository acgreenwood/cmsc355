package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AppSettings extends AppCompatActivity {

    Button returnHomeFromSettings;
    Button notificationSettings;
    Button appearanceSettings;
    Button myArchiveSettings;
    Button myProfileSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        //"Notification Settings" button.
        notificationSettings = (Button)findViewById(R.id.notifications_button);
        //"Appearance Settings" button.
        appearanceSettings = (Button)findViewById(R.id.appearance_button);
        //"My Archive Settings" button
        myArchiveSettings = (Button)findViewById(R.id.my_archive_settings);
        //"Go to My Profile" button.
        myProfileSettings = (Button)findViewById(R.id.my_profile_button);
        //"Return Home" button.
        returnHomeFromSettings = (Button)findViewById(R.id.return_to_home_page);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.my_archive_settings) {
            Intent myArchive = new Intent(this, MyArchiveSettings.class);
            startActivity(myArchive);
        } else if (choice.getId() == R.id.my_profile_button) {
            Intent myProfile = new Intent(this, MyProfile.class);
            startActivity(myProfile);
        } else if (choice.getId() == R.id.notifications_button) {
            Intent notificationsSettings = new Intent(this, NotificationSettings.class);
            //brings user to the notifications settings screen
            startActivity(notificationsSettings);
        } else if (choice.getId() == R.id.appearance_button) {
            Intent appearanceSettings = new Intent(this, AppearanceSettings.class);
            //brings user to the appearance settings screen
            startActivity(appearanceSettings);
        } else if (choice.getId() == R.id.return_to_home_page) {
            Intent homePage = new Intent(this, HomePage.class);
            startActivity(homePage);
        }
    }
}

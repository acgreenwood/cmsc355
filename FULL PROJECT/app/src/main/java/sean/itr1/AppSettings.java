package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppSettings extends AppCompatActivity {

    Button returnHomeFromSettings, notificationSettings, appearanceSettings, myArchiveSettings, myProfileSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        notificationSettings = (Button)findViewById(R.id.notifications_button);  //"Notification Settings" button.
        appearanceSettings = (Button)findViewById(R.id.appearance_button);  //"Appearance Settings" button.
        myArchiveSettings = (Button)findViewById(R.id.my_archive_settings); //"My Archive Settings" button
        myProfileSettings = (Button)findViewById(R.id.my_profile_button);  //"Go to My Profile" button.
        returnHomeFromSettings = (Button)findViewById(R.id.return_to_home_page);  //"Return Home" button.
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.my_archive_settings){
            Intent myArchive = new Intent(this, MyArchiveSettings.class);
            startActivity(myArchive);
        }

        else if (choice.getId() == R.id.my_profile_button){
            Intent myProfile = new Intent(this, MyProfile.class);
            startActivity(myProfile);
        }

        else if (choice.getId() == R.id.notifications_button){
            Intent notificationsSettings = new Intent(this, NotificationSettings.class);
            startActivity(notificationsSettings);    //If selected, brings user to the notifications settings screen (specified as activity_notification_settings.xml/NotificationSettings.class).
        }

        else if (choice.getId() == R.id.appearance_button){
            Intent appearanceSettings = new Intent(this, AppearanceSettings.class);
            startActivity(appearanceSettings);    //If selected, brings user to the appearance settings screen (specified as activity_appearance_settings.xml/AppearanceSettings.class).
        }
        else if(choice.getId() == R.id.return_to_home_page){
            finish();
        }
    }
}

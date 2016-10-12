package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationSettings extends AppCompatActivity {

    Button returnHomeFromNotificationSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings_page);

        returnHomeFromNotificationSettings = (Button)findViewById(R.id.returnHome4);  //"Return Home" button.

    }

    public void onClick(View choice){
        if (choice.getId() == R.id.returnHome4){
            Intent settingsToHome = new Intent(this, HomePage.class);
            startActivity(settingsToHome);    //Returns user back to the Home Page
        }
    }
}

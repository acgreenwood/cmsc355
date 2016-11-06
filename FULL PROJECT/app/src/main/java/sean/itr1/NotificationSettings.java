package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NotificationSettings extends AppCompatActivity {

    Button returnHomeFromNotificationSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        returnHomeFromNotificationSettings = (Button)findViewById(R.id.returnHome4);

    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.returnHome4) {
            finish(); //Returns user back to the Home Page, assuming that was their last page
        }
    }
}

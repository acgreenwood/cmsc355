package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class NotificationSettings extends AppCompatActivity {

    public enum Notification{
        NEW_RELEASES,
        CURRENT_STATUS,
        RECOMMENDATIONS,
        NEW_ADDITIONS,
        APP_UPDATES
    }

    public enum MessagingType{
        E_MAIL,
        TEXT_MESSAGE
    }

    private static Notification NotifySettings = Notification.NEW_RELEASES;
    private static MessagingType MessagingTypeSettings = MessagingType.E_MAIL;

    Button returnHomeFromNotificationSettings;
    Button saveNotificationSettings;
    Switch newReleases;
    Switch statusUpdates;
    Switch recommendations;
    Switch newAdditions;
    Switch postUpdates;
    Switch email;
    Switch textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        returnHomeFromNotificationSettings = (Button)findViewById(R.id.returnHome4);
        saveNotificationSettings = (Button)findViewById(R.id.save_changes_button);

        //Switch calls for notifications to send out.
        newReleases = (Switch)findViewById(R.id.new_releases);
        statusUpdates = (Switch)findViewById(R.id.status_updates);
        recommendations = (Switch)findViewById(R.id.recommendations_switch);

        //Switches for app-based notifications
        newAdditions = (Switch)findViewById(R.id.additions_monthly_message);
        postUpdates = (Switch) findViewById(R.id.app_updates);

        //Switch calls for messaging type for app notifications.
        email = (Switch)findViewById(R.id.send_e_mail);
        textMessage = (Switch)findViewById(R.id.send_text);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.save_changes_button){
            if (newReleases.isChecked()) {
                changeNotificationSettings(Notification.NEW_RELEASES);
            }
            if (statusUpdates.isChecked()) {
                changeNotificationSettings(Notification.CURRENT_STATUS);
            }
            if (recommendations.isChecked()) {
                changeNotificationSettings(Notification.RECOMMENDATIONS);
            }
            if (newAdditions.isChecked()){
                changeNotificationSettings(Notification.NEW_ADDITIONS);
            }
            if (newAdditions.isChecked()){
                changeNotificationSettings(Notification.APP_UPDATES);
            }
            if (email.isChecked()) {
                MessagingTypeSettings = MessagingType.E_MAIL;
            }
            if (textMessage.isChecked()){
                MessagingTypeSettings = MessagingType.TEXT_MESSAGE;
            }
            finish();
        }
        if (choice.getId() == R.id.returnHome4) {
            finish(); //Returns user back to the Home Page, assuming that was their last page
        }
    }

    public void changeNotificationSettings(Notification newSettings) {NotifySettings = newSettings; }
    public static Notification getNotificationSettings(){ return NotifySettings;}
    public static MessagingType getMessageSettings(){ return MessagingTypeSettings;}
}

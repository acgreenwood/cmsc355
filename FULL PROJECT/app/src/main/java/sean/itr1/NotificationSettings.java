package sean.itr1;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class NotificationSettings extends AppCompatActivity {

    public enum Notification{
        NEW_RELEASES,
        CURRENT_STATUS,
        RECOMMENDATIONS
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
    Switch email;
    Switch textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        returnHomeFromNotificationSettings = (Button)findViewById(R.id.returnHome4);
        saveNotificationSettings = (Button)findViewById(R.id.save_changes_button);

        //Switch calls for notifications to send out.
        newReleases = (Switch)findViewById(R.id.new_releases_switch);
        statusUpdates = (Switch)findViewById(R.id.update_status_switch);
        recommendations = (Switch)findViewById(R.id.recommendations_switch);

        //Switch calls for messaging type for app notifications.
        email = (Switch)findViewById(R.id.e_mail_switch);
        textMessage = (Switch)findViewById(R.id.text_message_switch);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.save_changes_button){
            //Switches for what notifications to send out.
            if (newReleases.isChecked()) {
                changeNotificationSettings(Notification.NEW_RELEASES);
            }
            if (statusUpdates.isChecked()) {
                changeNotificationSettings(Notification.CURRENT_STATUS);
            }
            if (recommendations.isChecked()) {
                changeNotificationSettings(Notification.RECOMMENDATIONS);
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

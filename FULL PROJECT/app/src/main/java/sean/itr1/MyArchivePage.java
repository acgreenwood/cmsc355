package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyArchivePage extends AppCompatActivity {

    Button backOutFromMyArchive;
    Button myArchiveSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_page);

        backOutFromMyArchive = (Button)findViewById(R.id.back_button_my_archive);
        myArchiveSettings = (Button)findViewById(R.id.my_archive_settings);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.back_button_my_archive) {
            Intent home = new Intent(this, HomePage.class);
            startActivity(home);
        } else if (choice.getId() == R.id.my_archive_settings) {
            Intent archiveUserSettings = new Intent(this, MyArchiveSettings.class);
            startActivity(archiveUserSettings);
        }
    }
}

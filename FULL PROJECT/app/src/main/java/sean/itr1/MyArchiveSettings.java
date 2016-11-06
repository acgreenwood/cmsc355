package sean.itr1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MyArchiveSettings extends AppCompatActivity {

    Button saveMyArchiveChanges, cancelMyArchiveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_settings);

        saveMyArchiveChanges = (Button)findViewById(R.id.save_changes_button);
        cancelMyArchiveChanges = (Button)findViewById(R.id.cancel_changes_button);
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.cancel_changes_button){
            //No code needed here: This button will send the user back to the previous screen without making adjustments to MyArchive Page.
            finish();
        }
        else if (choice.getId() == R.id.save_changes_button){
            //Add code here that will save user changes to My Archive and send a broadcast intent stating so.
            finish();
        }
    }
}

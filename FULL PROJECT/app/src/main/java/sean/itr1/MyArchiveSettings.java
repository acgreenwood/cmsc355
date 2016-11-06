package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyArchiveSettings extends AppCompatActivity {

    Button saveMyArchiveChanges;
    Button cancelMyArchiveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_settings);

        saveMyArchiveChanges = (Button)findViewById(R.id.save_changes_button);
        cancelMyArchiveChanges = (Button)findViewById(R.id.cancel_changes_button);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.cancel_changes_button) {
            finish();
        } else if (choice.getId() == R.id.save_changes_button) {
            //Add code here that will save user changes to =
            //My Archive and send a broadcast intent stating so.
            finish();
        }
    }
}

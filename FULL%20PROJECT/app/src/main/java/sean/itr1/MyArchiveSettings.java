package sean.itr1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MyArchiveSettings extends AppCompatActivity {

    Button backToMyArchiveMain, saveMyArchiveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_settings);

        backToMyArchiveMain = (Button)findViewById(R.id.back_to_myArchiveMain);
        saveMyArchiveChanges = (Button)findViewById(R.id.save_myArchive_settings);
    }

    public void onClick(View choice){
        if(choice.getId() == R.id.back_to_myArchiveMain){
            finish();
        }
        else if (choice.getId() == R.id.save_myArchive_settings){
            //Add code here that will save the changes made to user's MyArchive.
            finish();
        }
    }
}

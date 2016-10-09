package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyProfile extends AppCompatActivity {

    Button returnHomeFromProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_page);

        returnHomeFromProfile = (Button)findViewById(R.id.returnHome3);
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.returnHome3){
            Intent profileToHome = new Intent(this, HomePage.class);
            startActivity(profileToHome);    //If selected, app searches its database for the series name. Currently no form of database exists, so it should bring users to the NoShowExistsWindow xml.
        }
    }
}

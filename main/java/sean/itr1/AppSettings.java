package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppSettings extends AppCompatActivity {

    Button returnHomeFromSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_page);

        returnHomeFromSettings = (Button)findViewById(R.id.returnHome2);
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.returnHome2){
            Intent settingsToHome = new Intent(this, HomePage.class);
            startActivity(settingsToHome);    //Returns user back to the Home Page
        }
    }
}

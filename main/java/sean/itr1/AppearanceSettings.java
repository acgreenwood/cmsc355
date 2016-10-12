package sean.itr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppearanceSettings extends AppCompatActivity {

    Button returnHomeFromAppearanceSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance_settings_page);

        returnHomeFromAppearanceSettings = (Button)findViewById(R.id.returnHome5);  //"Return Home" button.

    }

    public void onClick(View choice){
        if (choice.getId() == R.id.returnHome5){
            Intent settingsToHome = new Intent(this, HomePage.class);
            startActivity(settingsToHome);    //Returns user back to the Home Page
        }
    }
}

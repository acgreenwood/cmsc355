package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AppearanceSettings extends AppCompatActivity {

    Button returnHomeFromAppearanceSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance_settings);

        returnHomeFromAppearanceSettings = (Button)findViewById(R.id.returnHome5);

    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.returnHome5) {
            finish();   //Returns user back to the Home Page, assuming that was the last page
        }
    }
}

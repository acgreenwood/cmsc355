package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyProfile extends AppCompatActivity {

    Button returnHomeFromProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        returnHomeFromProfile = (Button)findViewById(R.id.returnHome3);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.returnHome3) {
            finish(); //Returns to previous page
        }
    }
}

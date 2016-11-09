/*
 * This is the window displayed for when a user wishes to add a new series into SEAN's database
 */

package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewHold extends AppCompatActivity {

    Series s;

    Button addHold;
    Button cancelAddition;
    EditText holdSeason;
    EditText holdEpisode;
    EditText holdTimeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        s = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hold);
        addHold = (Button)findViewById(R.id.confirm_addition_button);
        cancelAddition = (Button)findViewById(R.id.decline_addition_button);
        holdSeason= (EditText)findViewById(R.id.hold_season_edit_text);
        holdEpisode = (EditText)findViewById(R.id.hold_episode_edit_text);
        holdTimeStamp = (EditText)findViewById(R.id.hold_timeStamp_edit_text);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.add_hold_to_series) {
            HoldStatus aHold = new HoldStatus(true, Integer.parseInt(holdSeason.getText().toString()), Integer.parseInt(holdEpisode.getText().toString()), Integer.parseInt(holdTimeStamp.getText().toString()));
            s.setHold(aHold);
            finish();
        } else if (choice.getId() == R.id.cancel_action) {
            finish();
        }
    }
}

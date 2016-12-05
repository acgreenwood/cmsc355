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

    Series series;

    Button addHold;
    Button cancelAddition;
    EditText holdSeason;
    EditText holdEpisode;
    EditText holdTimeStamp;
    EditText holdPageNumber;
    EditText holdChapter;
    View errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        series = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hold);
        addHold = (Button)findViewById(R.id.confirm_addition_button);
        cancelAddition = (Button)findViewById(R.id.decline_addition_button);
        holdSeason = (EditText)findViewById(R.id.hold_season_edit_text);
        holdEpisode = (EditText)findViewById(R.id.hold_episode_edit_text);
        holdTimeStamp = (EditText)findViewById(R.id.hold_timeStamp_edit_text);
        holdPageNumber = (EditText)findViewById(R.id.hold_pageNumber_edit_text);
        holdChapter = (EditText)findViewById(R.id.hold_chapter_edit_text);
        errorMessage = findViewById(R.id.fill_text_fields_message);
        errorMessage.setVisibility(View.INVISIBLE);

        if(series.getType().equals("television") || series.getType().equals("anime")){ //hides text fields based on series type
            holdTimeStamp.setVisibility(View.INVISIBLE);
            holdPageNumber.setVisibility(View.INVISIBLE);
            holdChapter.setVisibility(View.INVISIBLE);
        }
        else if(series.getType().equals("movie")){
            holdEpisode.setVisibility(View.INVISIBLE);
            holdSeason.setVisibility(View.INVISIBLE);
            holdPageNumber.setVisibility(View.INVISIBLE);
            holdChapter.setVisibility(View.INVISIBLE);
        }
        if(series.getType().equals("book")){
            holdTimeStamp.setVisibility(View.INVISIBLE);
            holdSeason.setVisibility(View.INVISIBLE);
            holdEpisode.setVisibility(View.INVISIBLE);
        }
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.add_hold_to_series) {
            HoldStatus theHold = new HoldStatus();

            if(series.getType().equals("television") || series.getType().equals("anime")){ //hides text fields based on series type
                if(holdSeason.getText().equals("") || holdEpisode.getText().equals("")){  //brings up error message if there are empty fields
                    errorMessage.setVisibility(View.VISIBLE);
                }
                if(!(holdSeason.getText().equals("") || holdEpisode.getText().equals(""))) { //if fields are filled, then add the hold
                    theHold.setSeriesSeason(Integer.parseInt(holdSeason.getText().toString()));
                    theHold.setSeriesEpisode(Integer.parseInt(holdEpisode.getText().toString()));
                    finish();
                }
            }
            else if(series.getType().equals("movie")){
                if(holdTimeStamp.getText().equals("")){
                    errorMessage.setVisibility(View.VISIBLE);
                }
                if(!(holdTimeStamp.getText().equals(""))){
                    theHold.setSeriesTimeStamp(Integer.parseInt(holdTimeStamp.getText().toString()));
                    finish();
                }
            }
            else if(series.getType().equals("book")){
                if(holdChapter.getText().equals("") || holdPageNumber.getText().equals("")){
                    errorMessage.setVisibility(View.VISIBLE);
                }
                if(!(holdChapter.getText().equals("") || holdPageNumber.getText().equals(""))) {
                    theHold.setSeriesChapter(Integer.parseInt(holdChapter.getText().toString()));
                    theHold.setSeriesPageNumber(Integer.parseInt(holdPageNumber.getText().toString()));
                    finish();
                }
            }
        } else if (choice.getId() == R.id.cancel_action) {
            finish();
        }
    }
}

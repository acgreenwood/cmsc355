/*
 * This is the window displayed for when a user wishes to add a new series into SEAN's database
 */

package sean.itr1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.graphics.Color;


public class AddNewSeries extends AppCompatActivity {

    Button addSeries;
    Button cancelAddition;
    CheckBox checkBox;
    EditText seriesName;
    EditText seriesType;
    EditText seriesGenre;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_new_series);

        addSeries = (Button) findViewById(R.id.confirm_addition_button);
        cancelAddition = (Button) findViewById(R.id.decline_addition_button);

        checkBox = (CheckBox) findViewById(R.id.check_box);

        seriesName = (EditText) findViewById(R.id.series_name_edit_text);
        seriesType = (EditText) findViewById(R.id.series_type_edit_text);
        seriesGenre = (EditText) findViewById(R.id.series_genre_edit_text);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    }

    public void onClick(View choice) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        if (choice.getId() == R.id.add_series_to_database) {
            String title = seriesName.getText().toString();
            String type = seriesType.getText().toString();
            String genre = seriesGenre.getText().toString();
            int c = Color.rgb(255,102,102);
            if (title.isEmpty()){
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please enter a title!", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(c);

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
            else if (type.isEmpty()){
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please enter a type!", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(c);

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
            else if (genre.isEmpty()){
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please enter a genre!", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(c);

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
            else {
                int i = SeriesArchiveApi.getArchiveSize();
                SeriesArchiveApi.addSeries(new Series(i, title, type, genre));
                if(checkBox.isChecked()) {
                    MyArchive.addSeries(new Series(i, title, type, genre));
                }
                finish();
            }
        }
        if (choice.getId() == R.id.cancel_action) {
            finish();
        }
    }
}

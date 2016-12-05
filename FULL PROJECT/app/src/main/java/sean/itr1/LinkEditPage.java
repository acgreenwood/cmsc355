package sean.itr1;

/**
 * Created by Andrew on 11/26/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.graphics.Color;
import android.view.inputmethod.*;
import android.content.Context;

public class LinkEditPage extends AppCompatActivity {

    Button addImdbLink;
    Button addWikiLink;
    Button back;
    EditText imdbLinkUrl;
    EditText wikiLinkUrl;
    Series seriesToEdit;
    CoordinatorLayout coordinatorLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_edit);

        seriesToEdit = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        addImdbLink = (Button) findViewById(R.id.confirm_imdb_url);
        addWikiLink = (Button)findViewById(R.id.confirm_wiki_url);
        back = (Button) findViewById(R.id.back_button);

        imdbLinkUrl = (EditText) findViewById(R.id.imdb_url_input);
        wikiLinkUrl = (EditText) findViewById(R.id.wiki_url_input);

        if((seriesToEdit.getType().compareTo("Television") != 0) &&
                (seriesToEdit.getType().compareTo("Movie") != 0) &&
                (seriesToEdit.getType().compareTo("Anime") != 0)) {
            addImdbLink.setVisibility(View.INVISIBLE);  //this hides the button but still uses it for layout calculation
            imdbLinkUrl.setVisibility(View.INVISIBLE);  //same
        }

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    }


    public void onClick(View choice) {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow((null == getCurrentFocus()) ? null : getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS); //this stuff hides soft keyboard on button press
        if(choice.getId() == R.id.confirm_wiki_url) {
            int i = seriesToEdit.getId();
            String s = wikiLinkUrl.getText().toString();
            if(MemoryDatabase.getSeriesById(i).setWiki(s)) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "URL updated.", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(Color.rgb(102,255,102));

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
            else {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Invalid URL!", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(Color.rgb(255,102,102));

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
        }
        if(choice.getId() == R.id.confirm_imdb_url) {
            int i = seriesToEdit.getId();
            String s = imdbLinkUrl.getText().toString();
            if(MemoryDatabase.getSeriesById(i).setImdb(s)) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "URL updated.", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(Color.rgb(102,255,102));

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
            else {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Invalid URL!", Snackbar.LENGTH_SHORT);

                View snackBarView = snackbar.getView();

                snackBarView.setBackgroundColor(Color.rgb(255,102,102));

                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.BLACK);

                snackbar.show();
            }
        }
        if(choice.getId() == R.id.back_button) {
            finish();
        }
    }
}

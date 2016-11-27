package sean.itr1;

/**
 * Created by Andrew on 11/26/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LinkEditPage extends AppCompatActivity {

    Button addImdbLink;
    Button addWikiLink;
    Button back;
    EditText imdbLinkUrl;
    EditText wikiLinkUrl;
    Series seriesToEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_edit);

        seriesToEdit = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        addImdbLink = (Button) findViewById(R.id.confirm_imdb_url);
        addWikiLink = (Button)findViewById(R.id.confirm_wiki_url);
        back = (Button) findViewById(R.id.back_button);

        imdbLinkUrl = (EditText) findViewById(R.id.imdb_url_input);
        wikiLinkUrl = (EditText) findViewById(R.id.wiki_url_input);

    }

    //TODO: add alertDialog for when URL is invalid (use boolean return from setWiki/setImdb functions)

    public void onClick(View choice) {
        if(choice.getId() == R.id.confirm_wiki_url) {
            MemoryDatabase.getSeriesById(seriesToEdit.getId()).setWiki(wikiLinkUrl.getText().toString());
        }
        if(choice.getId() == R.id.confirm_imdb_url) {
            MemoryDatabase.getSeriesById(seriesToEdit.getId()).setImdb(imdbLinkUrl.getText().toString());
        }
        if(choice.getId() == R.id.back_button) {
            finish();
        }
    }
}

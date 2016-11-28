package sean.itr1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;

public class ShowInfo extends AppCompatActivity {

    Button imdb;
    Button wiki;
    Button addToArchive;
    Button removeFromArchive;
    Button linkPage;
    Button returnToList;
    TextView title;
    TextView type;
    TextView genre;
    Series seriesToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        seriesToShow = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        //TODO: button to edit links for shows with existing links
        //(currently only editable if show does not have a link)

        imdb = (Button) findViewById(R.id.imdb);

        if((seriesToShow.getType().compareTo("Television") == 0) ||
                 (seriesToShow.getType().compareTo("Movie") == 0) ||
                 (seriesToShow.getType().compareTo("Anime") == 0)) {
            //button changes depending on if show has imdb link or not
            if(seriesToShow.getImdb() != null) {
                imdb.setText("IMDb Link");
            }
            else {
                imdb.setText("Add IMDb Link");
            }
        }
        //button only appears if applicable
        else {
            imdb.setVisibility(View.INVISIBLE); //this hides the button but still uses it for layout calculation
        }                                       //should probably rewrite layout calculation so that we can use
                                                //View.GONE, but need to implement descriptions first, or at least
                                                //decide what to do with descriptions (remove them?)


        //button changes depending on if show has wikipedia link or not
        wiki = (Button) findViewById(R.id.wiki);
        if(seriesToShow.getWiki() != null) {
            wiki.setText("Wikipedia Link");
        }
        else {
            wiki.setText("Add Wikipedia Link");
        }

        returnToList = (Button) findViewById(R.id.return_to_list);

        //button changes depending on if show is in my archive or not
        if (MyArchive.inMyArchive(seriesToShow.getId())) {
            removeFromArchive = (Button) findViewById(R.id.add_remove_archive);
            removeFromArchive.setText("Remove from Archive");
        } else {
            addToArchive = (Button) findViewById(R.id.add_remove_archive);
            addToArchive.setText("Add to Archive");
        }

        linkPage = (Button) findViewById(R.id.edit_urls);

        title = (TextView) findViewById(R.id.title);
        type = (TextView) findViewById(R.id.type);
        genre = (TextView) findViewById(R.id.genre);

        title.setText("Title: " + seriesToShow.getTitle());
        type.setText("Type: " + seriesToShow.getType());
        genre.setText("Genre: " + seriesToShow.getGenre());

    }

    public void onClick(View choice) {
        if(choice.getId() == R.id.imdb) {
            if(seriesToShow.getImdb() != null) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(seriesToShow.getImdb()));
                startActivity(browserIntent);
            }
            else {
                //new screen for entering wikipedia link
                Intent intent = new Intent(this, LinkEditPage.class);
                intent.putExtra("id", seriesToShow.getId());
                startActivity(intent);
            }
        }

        if(choice.getId() == R.id.wiki) {
            if(seriesToShow.getWiki() != null) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(seriesToShow.getWiki()));
                startActivity(browserIntent);
            }
            else {
                //new screen for entering wikipedia link
                Intent intent = new Intent(this, LinkEditPage.class);
                intent.putExtra("id", seriesToShow.getId());
                startActivity(intent);
            }
        }

        if(choice.getId() == R.id.edit_urls) {
            Intent intent = new Intent(this, LinkEditPage.class);
            intent.putExtra("id", seriesToShow.getId());
            startActivity(intent);
        }

        if(choice.getId() == R.id.return_to_list) {
            finish();
        }

        if(choice.getId() == R.id.add_remove_archive) {
            if (MyArchive.inMyArchive(seriesToShow.getId())) {
                MyArchive.removeSeries(seriesToShow);
            } else {
                MyArchive.addSeries(seriesToShow);
            }
            //Currently have it go back to list after adding to/removing from archive
            //Feel free to change this if you think it should work differently
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if((seriesToShow.getType().compareTo("Television") == 0) ||
                (seriesToShow.getType().compareTo("Movie") == 0) ||
                (seriesToShow.getType().compareTo("Anime") == 0)) {
            //button changes depending on if show has imdb link or not
            if(seriesToShow.getImdb() != null) {
                imdb = (Button) findViewById(R.id.imdb);
                imdb.setText("IMDb Link");
            }
            else {
                imdb = (Button) findViewById(R.id.imdb);
                imdb.setText("Add IMDb Link");
            }
        }

        //button changes depending on if show has wikipedia link or not
        if(seriesToShow.getWiki() != null) {
            wiki = (Button) findViewById(R.id.wiki);
            wiki.setText("Wikipedia Link");
        }
        else {
            wiki = (Button) findViewById(R.id.wiki);
            wiki.setText("Add Wikipedia Link");
        }
    }

}

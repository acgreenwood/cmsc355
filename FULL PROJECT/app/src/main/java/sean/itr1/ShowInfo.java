package sean.itr1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowInfo extends AppCompatActivity {

    Button returnToList;
    Button addToArchive;
    Button removeFromArchive;
    TextView title;
    TextView type;
    TextView genre;
    Series seriesToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        seriesToShow = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        returnToList = (Button) findViewById(R.id.return_to_list);

        //button changes depending on if show is in my archive or not
        if (MyArchive.inMyArchive(seriesToShow.getId())) {
            removeFromArchive = (Button) findViewById(R.id.add_remove_archive);
            removeFromArchive.setText("Remove from Archive");
        } else {
            addToArchive = (Button) findViewById(R.id.add_remove_archive);
            addToArchive.setText("Add to Archive");
        }


        title = (TextView) findViewById(R.id.title);
        type = (TextView) findViewById(R.id.type);
        genre = (TextView) findViewById(R.id.genre);

        title.setText("Title: " + seriesToShow.getTitle());
        type.setText("Type: " + seriesToShow.getType());
        genre.setText("Genre: " + seriesToShow.getGenre());


    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.return_to_list) {
            finish();
        }
        if (choice.getId() == R.id.add_remove_archive) {
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

}

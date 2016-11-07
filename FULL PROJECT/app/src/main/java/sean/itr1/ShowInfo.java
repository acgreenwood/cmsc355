package sean.itr1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Andrew on 11/7/2016.
 */

public class ShowInfo extends AppCompatActivity {
    Button returnToList;
    TextView title, type, genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        returnToList = (Button)findViewById(R.id.return_to_list);

        Series s = MemoryDatabase.getSeriesById(getIntent().getExtras().getInt("id"));

        title = (TextView) findViewById(R.id.title);
        type = (TextView) findViewById(R.id.type);
        genre = (TextView) findViewById(R.id.genre);

        title.setText("Title: "+s.getTitle());
        type.setText("Type: "+s.getType());
        genre.setText("Genre: "+s.getGenre());


    }

    public void onClick(View choice) {
        if(choice.getId() == R.id.return_to_list) {
            finish();
        }
    }

}

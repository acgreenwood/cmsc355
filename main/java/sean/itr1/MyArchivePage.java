package sean.itr1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MyArchivePage extends AppCompatActivity {

    Button returnHomeFromMyArchive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_page);

        returnHomeFromMyArchive = (Button)findViewById(R.id.returnHome1);
    }

    public void onClick(View choice){
        if (choice.getId() == R.id.returnHome1){
            Intent archiveToHome = new Intent(this, HomePage.class);
            startActivity(archiveToHome);    //Returns user back to the Home Page
        }
    }
}

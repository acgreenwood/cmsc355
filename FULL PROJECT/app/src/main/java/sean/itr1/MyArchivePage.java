package sean.itr1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArchivePage extends AppCompatActivity implements OnItemClickListener {

    Button backOutFromMyArchive;
    Button myArchiveSettings;
    ListView myArchiveListView;
    Series[] archiveSeries;
    ArrayList<String> archiveArray;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_archive_page);

        backOutFromMyArchive = (Button) findViewById(R.id.back_button_my_archive);
        myArchiveSettings = (Button) findViewById(R.id.my_archive_settings);
        myArchiveListView = (ListView) findViewById(R.id.my_archive_list);
        myArchiveListView.setOnItemClickListener(this);

        archiveSeries = MyArchive.getMyArchive();

        archiveArray = new ArrayList<>();
        setArchiveArray(archiveSeries);

        adapter =
                new ArrayAdapter<>(this, R.layout.activity_listview, archiveArray);

        myArchiveListView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sortArchive();
        //archiveArray = new String[] {""};
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ShowInfo.class);
        Series s = archiveSeries[position];
        intent.putExtra("id", s.getId());
        startActivity(intent);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.back_button_my_archive) {
            Intent home = new Intent(this, HomePage.class);
            startActivity(home);
        } else if (choice.getId() == R.id.my_archive_settings) {
            Intent archiveUserSettings = new Intent(this, MyArchiveSettings.class);
            startActivity(archiveUserSettings);
        } else if (choice.getId() == R.id.my_archive_list) {
            finish();
        }
    }

    private void sortArchive() {

        final MyArchiveSettings.Sort sortSetting = MyArchiveSettings.getSortSetting();
        final MyArchiveSettings.SortOrder orderSetting = MyArchiveSettings.getOrderSetting();

        Series[] series = MyArchive.getMyArchive();

        Arrays.sort(series, new Comparator<Series>() {
            @Override
            public int compare(Series s1, Series s2) {
                if(sortSetting == MyArchiveSettings.Sort.TITLE) {
                    return (s1.getTitle().compareTo(s2.getTitle()));
                } else if(sortSetting == MyArchiveSettings.Sort.TYPE) {
                    return (s1.getType().compareTo(s2.getType()));
                } else if(sortSetting == MyArchiveSettings.Sort.GENRE) {
                    return (s1.getGenre().compareTo(s2.getGenre()));
                } else return 0;
            }
        });
        if(orderSetting == MyArchiveSettings.SortOrder.ASCENDING) {
            for(int i = 0; i < series.length / 2; i++) {
                Series temp = series[i];
                series[i] = series[series.length - 1 - i];
                series[series.length - 1 - i] = temp;
            }
        }

        setArchiveArray(series);
    }

    private void setArchiveArray(Series[] series) {
        archiveArray.clear();
        for (int i = 0; i < series.length; i++) {
            archiveArray.add("Title: " + series[i].getTitle()
                    + "\nType: " + series[i].getType()
                    + "\nGenre: " + series[i].getGenre() + "\n");
        }
        archiveSeries = series;
    }

}

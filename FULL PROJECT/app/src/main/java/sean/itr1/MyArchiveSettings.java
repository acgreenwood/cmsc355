package sean.itr1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class MyArchiveSettings extends AppCompatActivity {

    Button saveMyArchiveChanges;
    Button cancelMyArchiveChanges;
    RadioButton titleSort;
    RadioButton typeSort;
    RadioButton ascending;
    RadioButton descending;
    RadioButton genreSort;

    public enum Sort {
        TITLE, TYPE, GENRE
    }

    public enum SortOrder {
        ASCENDING, DESCENDING
    }

    private static Sort sortSetting = Sort.TITLE;
    private static SortOrder orderSetting = SortOrder.DESCENDING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_archive_settings);

        titleSort = (RadioButton) findViewById(R.id.title_sort);
        typeSort = (RadioButton) findViewById(R.id.type_sort);
        genreSort = (RadioButton) findViewById(R.id.genre_sort);
        descending = (RadioButton) findViewById(R.id.a_z_sort);
        ascending = (RadioButton) findViewById(R.id.z_a_sort);

        saveMyArchiveChanges = (Button)findViewById(R.id.save_changes_button);
        cancelMyArchiveChanges = (Button)findViewById(R.id.cancel_changes_button);
    }

    public void onClick(View choice) {
        if (choice.getId() == R.id.cancel_changes_button) {
            finish();
        } else if (choice.getId() == R.id.save_changes_button) {
            if (titleSort.isChecked()) {
                changeSortSetting(Sort.TITLE);
            } else if (typeSort.isChecked()) {
                changeSortSetting(Sort.TYPE);
            } else if (genreSort.isChecked()) {
                changeSortSetting(Sort.GENRE);
            }
            if (ascending.isChecked()) {
                orderSetting = SortOrder.ASCENDING;
            } else {
                orderSetting = SortOrder.DESCENDING;
            }
            finish();
        }
    }

    public void changeSortSetting(Sort newSetting) {
        sortSetting = newSetting;
    }

    public static Sort getSortSetting() {
        return sortSetting;
    }

    public static SortOrder getOrderSetting() {
        return orderSetting;
    }
}

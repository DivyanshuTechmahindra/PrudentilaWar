package uk.prudential.businessunit1.splashscreen.filter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import uk.prudential.R;

/**
 * Created by user on 8/10/2016.
 */
public class FilterActivity extends Activity {

    Spinner spinner_UserAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
         spinner_UserAge = (Spinner) findViewById(R.id.spinnerage);
        spinner_UserAge.setFocusableInTouchMode(true);
        // String userName[] = {"Transporter","User","Warehouse"};

        ArrayAdapter<String> adptSpnCategory = new ArrayAdapter<String>(this, R.layout.custom_spinner_item, getResources().getStringArray(R.array.age));
        adptSpnCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_UserAge.setAdapter(adptSpnCategory);
        spinner_UserAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(), spinner_UserAge.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        
    }
}

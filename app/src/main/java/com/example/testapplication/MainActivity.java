package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//     The very first method that gets triggered upon triggering the activity
//     Life cycle : onCreate()-> onStart()-> onResume()-> onPause()-> onStop()-> onDestroy()
//                        - onPause() -> onResume()
//                        - onStop() -> onRestart() -> onStart()
//                        - onStop() -> onCreate()

    EditText etID;
    Button btnSubmit;
    TextView tvResults;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view while creating. In the resource folder, in the layout folder there will be a file activity_main.xml which is the layout file while stating the activity
        // It is basically a R.java file which get auto generated whenever you make changes in the resource folder
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        // This is just to remove the text view created to show results, before use enters the value
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etID.getText().toString().trim();
                String doB = id.substring(0, 6);
                int gender = Integer.parseInt(Character.toString(id.charAt(6)));
                String sGender = getGender(gender);
                int citizenship = Integer.parseInt(Character.toString(id.charAt(10)));
                String sNationality = getNationality(citizenship);
                tvResults.setText(getString(R.string.DoB)+ doB + "\n" +
                                  getString(R.string.gender) + sGender + "\n" +
                                    getString(R.string.Nationality) + sNationality);

                // Set the previously unset visibility so that it will be displayed in the screen
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }

    private String getGender(int gender) {
        if(gender < 5)
            // Will be read from resource string.xml file. This will be useful at the time of translation and to avoid hard coding
            return getString(R.string.female);
        else
            return getString(R.string.male);
    }

    private String getNationality(int citizenship) {
        if(citizenship == 0)
            return getString(R.string.citizen);
        else
            return getString(R.string.resident);
    }

}
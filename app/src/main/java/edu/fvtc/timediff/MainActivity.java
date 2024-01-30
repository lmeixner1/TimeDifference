package edu.fvtc.timediff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        initTextChangeEvent();

    }

    private void initTextChangeEvent() {
        EditText etStartTimeInput = findViewById(R.id.etStartInput);
        EditText etEndTimeInput = findViewById(R.id.etEndTimeInput);
        etStartTimeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Log.d(TAG, "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d(TAG, "onTextChanged: ");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterStartTimeChanged: ");

            }
        });

        etEndTimeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Log.d(TAG, "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d(TAG, "onTextChanged: ");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterEndTimeChanged: ");

            }
        });
    }

    private void initButton() {
        // Get the xml control
        Button btnTimeDiff = findViewById(R.id.btnTimeDiff);

        // Write the click handler
        btnTimeDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Time Diff clicked");
                //


                // Show the output of the Time Difference
                TextView etTimeDiffDisplay = findViewById(R.id.tvTimeDiffDisplay);




            }
        });
    }
}
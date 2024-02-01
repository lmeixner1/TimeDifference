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

    public EditText etStartTimeInput;
    public EditText etEndTimeInput;
    public TextView tvTimeDiffDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        etStartTimeInput = findViewById(R.id.etStartInput);
        etEndTimeInput = findViewById(R.id.etEndTimeInput);
    }


    private void initButton() {
        // Get the xml control
        Button btnTimeDiff = findViewById(R.id.btnTimeDiff);

        // Write the click handler
        btnTimeDiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Time Diff clicked");
                calculateTimeDifference();

            }
        });
    }


    private void calculateTimeDifference() {
        //Get controls
        EditText etStartTimeInput = findViewById(R.id.etStartInput);
        EditText etEndTimeInput = findViewById(R.id.etEndTimeInput);
        TextView tvTimeDiffDisplay = findViewById(R.id.tvTimeDiffDisplay);

        //change from text to string
        String startTime = etStartTimeInput.getText().toString();
        String endTime = etEndTimeInput.getText().toString();

        //Check the values between the ":"
        String[] startTimeString = startTime.split(":");
        String[] endTimeString = endTime.split(":");

        // Check for empty start or end time
        if (startTime.isEmpty() || endTime.isEmpty()) {
            tvTimeDiffDisplay.setText(R.string.missing_input_try_again);
            return;
        }

        // Check for correct time format
        if (startTimeString.length != 3 || endTimeString.length != 3) {
            tvTimeDiffDisplay.setText(R.string.time_formatted_incorrectly_please_use_hh_mm_ss);
            return;
        }

        try {
            // seconds in an hour = 3600, minutes = 60
            //Convert start and end into seconds since midnight
            int startSeconds = Integer.parseInt(startTimeString[0]) * 3600 +
                    Integer.parseInt(startTimeString[1]) * 60 +
                    Integer.parseInt(startTimeString[2]);

            int endSeconds = Integer.parseInt(endTimeString[0]) * 3600 +
                    Integer.parseInt(endTimeString[1]) * 60 +
                    Integer.parseInt(endTimeString[2]);

            //Calculate time difference
            int timeDifference = 0;


            // Calculate time difference in seconds
            timeDifference = endSeconds - startSeconds;

            if (timeDifference < 0) {
                tvTimeDiffDisplay.setText(R.string.start_time_is_greater_than_end_time);
                return;
            }

            // seconds in an hour = 3600, minutes = 60
            // convert into hours, and minutes
            int hours = timeDifference / 3600;
            int minutes = (timeDifference % 3600) / 60;
            int seconds = timeDifference % 60;

            //Display result
            String result = timeDifference + " " + "=" + " " + String.format("%02d:%02d:%02d", hours, minutes, seconds);
            tvTimeDiffDisplay.setText(result);

        } catch (Exception e) {
            Log.e(TAG, "Error calculating time difference: Start time is greater than end time");
            tvTimeDiffDisplay.setText(R.string.start_time_is_greater_than_end_time);
        }


    }

}
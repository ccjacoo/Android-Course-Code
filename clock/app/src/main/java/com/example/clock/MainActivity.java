package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private ClockView clockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        clockView = (ClockView) findViewById(R.id.clock);
    }
    @Override
    protected void onResume() {
        super.onResume();
        clockView.startClock();
    }
    @Override
    protected void onStop() {
        super.onStop();
        clockView.stopClock();
    }
}
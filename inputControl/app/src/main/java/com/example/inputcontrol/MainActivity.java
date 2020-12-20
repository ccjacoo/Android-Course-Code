package com.example.inputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        //is the button now checked ?
        boolean checked = ((RadioButton) view).isChecked();
        //Check which radio button was clicked.
        switch(view.getId()){
            case R.id.sameday:
                if(checked) displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked) displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if(checked) displayToast(getString(R.string.pick_up));
                break;
            default:
                break;
        }
    }
}


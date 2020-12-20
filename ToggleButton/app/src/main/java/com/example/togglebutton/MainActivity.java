package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTextNumber1=(EditText)this.findViewById(R.id.editText_number1);
        this.editTextNumber2=(EditText)this.findViewById(R.id.editText_number2);
        this.buttonAdd=(Button)this.findViewById(R.id.button_add);

        this.buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                add2Number();
            }
        });

        //CompoundButton button = (ToggleButton)findViewById(R.id.toggleButton);
        //button.toggle();   // switch between two states ,from ON (checked) Or OFF (unchecked)
        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        final TextView textView24 = (TextView)findViewById(R.id.textView24);
        toggleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean checked = ((ToggleButton) v).isChecked();   //
                if(checked){
                    //code
                    textView24.setText("Yeah ! The Toggle Button is ON !!!!");
                }
                else{
                    textView24.setText("NOOOOO ,The Toggle Button is OFF !!");
                }
            }
        });

    }

    //实现两数相加的函数
    private void add2Number(){
        String str1 = this.editTextNumber1.getText().toString();
        String str2 = this.editTextNumber2.getText().toString();
        try{
            double value1 = Double.parseDouble(str1);
            double value2 = Double.parseDouble(str2);
            double result = value1 + value2;
            Toast.makeText(this,"Result:"+result,Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this,"Error:"+e,Toast.LENGTH_SHORT).show();
        }
    }

}
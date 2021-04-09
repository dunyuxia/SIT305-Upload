package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button1, button2, button3;
    TextView textView1, textView2, textView3;
    EditText edittext;
    Spinner spinner1;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.itemname, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        edittext = findViewById(R.id.edittext);
        spinner1 = findViewById(R.id.spinner1);
    }

    public void MeterClick(View view) {
        try {
            if(Objects.equals(text, "Meter")) {

                double resultone = Double.parseDouble(edittext.getText().toString()) * 100;
                BigDecimal num1 = new BigDecimal(resultone);
                textView1.setText((num1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " CM");

                double resulttwo = Double.parseDouble(edittext.getText().toString()) * 3.28;
                BigDecimal num2 = new BigDecimal(resulttwo);
                textView2.setText((num2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Foot");

                double resultthree = Double.parseDouble(edittext.getText().toString()) * 39.37;
                BigDecimal num3 = new BigDecimal(resultthree);
                textView3.setText((num3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Inch");
            }
            Toast.makeText(MainActivity.this, "Please Select The Right button" , Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CelsiusClick(View view) {
        try {
            if(Objects.equals(text, "Celsius")) {

                double resultone = Double.parseDouble(edittext.getText().toString()) * 9 / 5 + 32;
                BigDecimal num1 = new BigDecimal(resultone);
                textView1.setText((num1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Fahrenheit");

                double resulttwo = Double.parseDouble(edittext.getText().toString()) + 273.15;
                BigDecimal num2 = new BigDecimal(resulttwo);
                textView2.setText((num2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Kelvin");

                textView3.setText("");
            }
            Toast.makeText(MainActivity.this, "Please Select The Right button" , Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void KilogramClick(View view) {
        try {
            if (Objects.equals(text, "Kilogram")) {

                double resultone = Double.parseDouble(edittext.getText().toString()) * 1000;
                BigDecimal num1 = new BigDecimal(resultone);
                textView1.setText((num1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Gram");

                double resulttwo = Double.parseDouble(edittext.getText().toString()) * 35.274;
                BigDecimal num2 = new BigDecimal(resulttwo);
                textView2.setText((num2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Ounce(Oz)");

                double resultthree = Double.parseDouble(edittext.getText().toString()) * 2.205;
                BigDecimal num3 = new BigDecimal(resultthree);
                textView3.setText((num3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + " Pound(lb)");

                Toast.makeText(MainActivity.this, "Hello " + edittext.getText().toString(), Toast.LENGTH_LONG).show();
            }
            Toast.makeText(MainActivity.this, "Please Select The Right button" , Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        edittext.setText("");
        textView1.setText("");
        textView2.setText("");
        textView3.setText("");
        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

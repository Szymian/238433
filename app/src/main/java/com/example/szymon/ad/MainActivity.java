package com.example.szymon.ad;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    private EditText wzrost, masa;
    private EditText poleMasa, poleWzrost;
    private Switch switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        masa = findViewById(R.id.et1);
        wzrost = findViewById(R.id.et2);
        switcher = findViewById(R.id.switcher);


        try {
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void authorButtonOnClick(android.view.View v) {
        startAuthorActivity();
    }

    public void calculateBMIButtonOnClick(android.view.View v){
        double bmi = -1.0;


        String str1 = masa.getText().toString();
        String str2 = wzrost.getText().toString();


        double weight = Double.parseDouble(str1);
        double height = Double.parseDouble(str2);

        try {
            if(switcher.isChecked()) {
                BMInieKG bmiClass = new BMInieKG(weight, height);
                bmi = bmiClass.calculateBmi();
            }
            else {
                //   BMIkg bmiClass = new BMIkg(Double.parseDouble(masa.getText().toString()), Double.parseDouble(wzrost.getText().toString()));
                BMIkg bmiClass = new BMIkg(weight, height);
                bmi = bmiClass.calculateBmi();
            }
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
        }

        if(bmi == -1.0){

        }
        else {
            Intent intent = new Intent(v.getContext(), ShowBMI.class);
            intent.putExtra("bmiValue", bmi);
            startActivity(intent);
        }
    }



    public void saveOnClick(MenuItem item) throws IOException {
        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "save_bmi_file.txt");
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write((poleMasa.getText().toString() + System.getProperty("line.separator")).getBytes());
            stream.write(poleWzrost.getText().toString().getBytes());
        } catch (IOException e){}
        finally {
            stream.close();
        }

    }

    public void readData() throws IOException {
        File path = getApplicationContext().getFilesDir();
        File file = new File(path, "save_bmi_file.txt");

        FileInputStream in = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        if((line = br.readLine()) != null) poleMasa.setText(line);
        if((line = br.readLine()) != null) poleWzrost.setText(line);

        in.close();
        isr.close();
        br.close();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public void startAuthorActivity(){
        Intent intent = new Intent(getApplicationContext(), Autor.class);
        startActivity(intent);
    }


}
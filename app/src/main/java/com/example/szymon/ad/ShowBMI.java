package com.example.szymon.ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowBMI extends AppCompatActivity {

    private Double bmi;
    private TextView showBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi);
        showBMI = findViewById(R.id.wynikBMI);

        bmi = Math.round(getIntent().getDoubleExtra("bmiValue", 0) * 100.0) / 100.0;
        chooooooooseColor(bmi);

      //  showBMI.setText(bmi.toString());

        String bmiInterpretation = interpretBMI(bmi);
        showBMI.setText(String.valueOf(bmi + " - "+ bmiInterpretation));
    }

    private String interpretBMI(double bmiValue) {

        if (bmiValue < 16) {

            return "niedowaga";
        } else if (bmiValue < 18.5) {

            return "nieco za malo";
        } else if (bmiValue < 25) {

            return "wporzo";
        } else if (bmiValue < 30) {

            return "nieco za duzo";
        } else {
            return "nooooooo!";
        }
    }

    private void chooooooooseColor (double bmiValue){
        if (bmiValue < 16) {

            showBMI.setTextColor( getResources().getColor( R.color.colorAccent) );


        } else if (bmiValue < 25) {

            showBMI.setTextColor( getResources().getColor( R.color.colorPrimary) );

        } else {
            showBMI.setTextColor( getResources().getColor( R.color.colorPrimaryDark) );
        }

    }

}
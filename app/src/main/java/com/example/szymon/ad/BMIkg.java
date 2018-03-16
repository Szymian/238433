package com.example.szymon.ad;

/**
 * Created by Szymon on 15.03.2018.
 */

public class BMIkg extends BMI{

    public BMIkg(double masa, double wzrost){
        super(masa, wzrost);
    }

    @Override
    public double calculateBmi() throws IllegalArgumentException {
        if(DataSens()){
            return masa / (wzrost /100 * wzrost /100);
        }
        else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    protected boolean DataSens() {
        return masa > 0 && masa < 500 && wzrost > 0 && wzrost < 300;
    }


}
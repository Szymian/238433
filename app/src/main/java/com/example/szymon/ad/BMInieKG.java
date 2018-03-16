package com.example.szymon.ad;

/**
 * Created by Szymon on 15.03.2018.
 */
class BMInieKG extends BMI {

    public BMInieKG(double masa, double wzrost){
        super(masa, wzrost);
    }

    @Override
    public double calculateBmi() throws IllegalArgumentException {
        if(DataSens()){
            return (masa / (wzrost * wzrost)) * 703;
        }
        else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    protected boolean DataSens() {
        return masa > 0 && masa < 1000 && wzrost > 0 && wzrost < 150;
    }
}


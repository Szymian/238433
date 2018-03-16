package com.example.szymon.ad;

/**
 * Created by Szymon on 15.03.2018.
 */

public abstract class BMI {
    protected double masa, wzrost;
    public BMI(double masa, double wzrost){
        this.masa = masa;
        this.wzrost = wzrost;
    }
    public abstract double calculateBmi() throws IllegalAccessException;
    protected abstract boolean DataSens();
}
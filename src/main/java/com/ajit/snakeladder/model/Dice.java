package com.ajit.snakeladder.model;

import java.util.Random;

public class Dice {
    private int minValue;
    private int maxValue;
    private int currValue;
    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getCurrValue() {
        return currValue;
    }

    public void setCurrValue(int currValue) {
        this.currValue = currValue;
    }

    public Dice(int minValue, int maxValue, int currValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currValue = currValue;
    }

    public int roll(){
        Random ran = new Random();
        int num = ran.nextInt(6)+1;
        return num;
    }


}

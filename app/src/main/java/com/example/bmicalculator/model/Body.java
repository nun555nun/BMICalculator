package com.example.bmicalculator.model;

import android.util.Log;

public class Body {
    private int height;
    private int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float calculateBMI() {
        float heightInM = this.height / 100f;

        float bmi = this.weight / (heightInM * heightInM);
        return bmi;
    }

    public String getResultText() {
        float bmi = calculateBMI();
        String resultText = null;
        if (bmi < 18.5) {
            resultText = "ผอมปายยยยยยยย";
        } else if (bmi < 25) {
            resultText = "ปกติ";
        } else if (bmi < 30) {
            resultText = "อ้วน";
        } else {
            resultText = "อ้วนปาย";
        }
        return resultText;
    }
}

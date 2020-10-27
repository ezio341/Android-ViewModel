package com.argadiaz.viewmodel2.models;

public class SplitBillModel {
    private float amount;
    private int people;
    private String result;

    public SplitBillModel(float amount, int people, String result) {
        this.amount = amount;
        this.people = people;
        this.result = result;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getResult() {
        float res = amount/people;
        if(amount==0 && people==0){
            return "0";
        }
        return String.valueOf(res);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public SplitBillModel() {
    }
}

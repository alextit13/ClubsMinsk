package com.acherniakovich.android.classes;

import java.io.Serializable;

public class Discount implements Serializable{
    String klub_name;
    String date_discount;

    public Discount() {
    }

    public Discount(String klub_name, String date_discount) {
        this.klub_name = klub_name;
        this.date_discount = date_discount;
    }

    public String getKlub_name() {
        return klub_name;
    }

    public void setKlub_name(String klub_name) {
        this.klub_name = klub_name;
    }

    public String getDate_discount() {
        return date_discount;
    }

    public void setDate_discount(String date_discount) {
        this.date_discount = date_discount;
    }
}

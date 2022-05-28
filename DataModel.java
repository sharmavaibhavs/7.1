package com.example.sit305_7_1p;

import androidx.annotation.Nullable;

public class DataModel {
    private String LostOrFound;
    private String Name;
    private int Phone;
    private String Description;
    private String Date;
    private String Location;
    private int alertID;

    public DataModel(String lostOrFound, String name, int phone, String description, String date, String location) {
        LostOrFound = lostOrFound;
        Name = name;
        Phone = phone;
        Description = description;
        Date = date;
        Location = location;
    }

    public DataModel(int AlertID, String lostOrFound, String name, int phone, String description, String date, String location) {
        LostOrFound = lostOrFound;
        Name = name;
        Phone = phone;
        Description = description;
        Date = date;
        Location = location;
        alertID = AlertID;

    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int AlertID) {
        alertID = AlertID;
    }

    public String getLostOrFound() {
        return LostOrFound;
    }

    public void setLostOrFound(String lostOrFound) {
        LostOrFound = lostOrFound;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }


}

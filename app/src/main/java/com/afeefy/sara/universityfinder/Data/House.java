package com.afeefy.sara.universityfinder.Data;

/**
 * Created by user on 22/11/2017.
 */

public class House
{
    private String numberinhouse;
    private Double roomspace;
    private boolean isCompleted;
    private String phonenumber;
    private String address;
    private String keyId;
    public House()
    {
        this.numberinhouse = numberinhouse;
        this.roomspace = roomspace;
        isCompleted=false;
        this.phonenumber=phonenumber;
        this.address=address;

    }
    public House(String numberinhouse,Double roomspace,boolean isCompleted,String phonenumber, String address ,String keyId) {
        this.numberinhouse = numberinhouse;
        this.roomspace = roomspace;
        this.isCompleted = isCompleted;
        this.keyId = keyId;
        this.phonenumber=phonenumber;
        this.address=address;
    }


    public String getNumberinhouse() {
        return numberinhouse;
    }

    public void setNumberinhouse(String numberinhouse) {
        this.numberinhouse = numberinhouse;
    }

    public Double getRoomspace() {
        return roomspace;
    }

    public void setRoomspace(Double roomspace) {
        this.roomspace = roomspace;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getPhonenumber() { return phonenumber; }

    public void setPhonenumber(String phonenumber){this.phonenumber=phonenumber;}

    public String getAddress() {return address;}

    public void setAddress (String address) {this.address=address;}



















}

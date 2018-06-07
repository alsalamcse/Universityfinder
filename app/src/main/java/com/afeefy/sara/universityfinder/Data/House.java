package com.afeefy.sara.universityfinder.Data;

/**
 * Created by user on 22/11/2017.
 */

public class House {
    private String numberinhouse;
    private Double roomspace;
    private boolean isCompleted;
    private String phonenumber;
    private String address;
    private String city;
    private String gender;
    private Double lat;
    private Double lung;
    private String subject;
    private int yearsubject;
    private String Email;
    private String keyId;


    public House() {
    }

    public House(String numberinhouse, Double roomspace, boolean isCompleted, String phonenumber, String address, String city, String gender, Double lat, Double lung, String subject, int yearsubject, String email, String keyId) {
        this.numberinhouse = numberinhouse;
        this.roomspace = roomspace;
        this.isCompleted = isCompleted;
        this.phonenumber = phonenumber;
        this.address = address;
        this.city = city;
        this.gender = gender;
        this.lat = lat;
        this.lung = lung;
        this.subject = subject;
        this.yearsubject = yearsubject;
        Email = email;
        this.keyId = keyId;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLung() {
        return lung;
    }

    public void setLung(Double lung) {
        this.lung = lung;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYearsubject() {
        return yearsubject;
    }

    public void setYearsubject(int yearsubject) {
        this.yearsubject = yearsubject;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }


    @Override
    public String toString() {
        return "House{" +
                "numberinhouse='" + numberinhouse + '\'' +
                ", roomspace=" + roomspace +
                ", isCompleted=" + isCompleted +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", lat=" + lat +
                ", lung=" + lung +
                ", subject='" + subject + '\'' +
                ", yearsubject=" + yearsubject +
                ", Email='" + Email + '\'' +
                ", keyId='" + keyId + '\'' +
                '}';
    }
}
























package com.afeefy.sara.universityfinder.Data;

/**
 * Created by user on 22/11/2017.
 */

public class House
{
    private String numberinhouse;
    private Double roomspace;
    private boolean isCompleted;
    private String imgPath;
    private String keyId;
    public House(String numberinhouse,Double roomspace)
    {
        this.numberinhouse = numberinhouse;
        this.roomspace = roomspace;
        isCompleted=false;
        imgPath=null;
    }
    public House(String numberinhouse,Double roomspace,boolean isCompleted,String imgPath,String keyId) {
        this.numberinhouse = numberinhouse;
        this.roomspace = roomspace;
        this.isCompleted = isCompleted;
        this.imgPath = imgPath;
        this.keyId = keyId;
    }
    public House()
    {

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

















}

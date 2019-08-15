package com.example.itemlistmlbb.model;

import android.os.Parcel;
import android.os.Parcelable;

public class barang {
    private String name;
    private String explain;
    private String img;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String image) {
        this.img = image;
    }


}

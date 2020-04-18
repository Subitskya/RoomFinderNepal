package com.example.roomfindernepal;

public class singleModelClass {
    private int image;
    private String type;
    private String detail;

    public singleModelClass(int image, String type, String detail) {
        this.image = image;
        this.type = type;
        this.detail = detail;
    }

    public int getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }
}

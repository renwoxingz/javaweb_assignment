package com.example.javaweb_assignment.pojo;

public class Goods {
    private String name;
    private String belong;
    private float price;
    private String info;
    private String picture;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goods(String name, String belong, float price, String info, String picture, int id) {
        this.name = name;
        this.belong = belong;
        this.price = price;
        this.info = info;
        this.picture = picture;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", belong='" + belong + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", picture='" + picture + '\'' +
                ", id=" + id +
                '}';
    }
}

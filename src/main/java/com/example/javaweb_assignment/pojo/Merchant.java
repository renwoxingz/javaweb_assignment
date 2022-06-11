package com.example.javaweb_assignment.pojo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Merchant {
    private String name;
    private String id;
    private String password;
    private String info;

    private String registerDate;

    public Merchant(String  id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Merchant(String name, String id, String password, String info) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.info = info;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.registerDate = simpleDateFormat.format(date);
    }

    public Merchant(String name, String id, String password, String info, String registerDate) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.info = info;
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", info='" + info + '\'' +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}

package com.example.farmerportal;

public class dataholder {


    String photo,phone;

    public dataholder(String photo, String phone) {
        this.photo = photo;
        this.phone = phone;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

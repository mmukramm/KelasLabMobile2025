package com.example.pertemuan3kelasa;

public class Cat {
    private String name;
    private int age;
    private String profileImg;

    public Cat(String name, int age, String profileImg) {
        this.name = name;
        this.age = age;
        this.profileImg = profileImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}

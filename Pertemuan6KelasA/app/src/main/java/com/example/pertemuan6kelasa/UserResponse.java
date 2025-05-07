package com.example.pertemuan6kelasa;

import java.util.List;

public class UserResponse {
    private List<User> data;

    public UserResponse(List<User> data) {
        this.data = data;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "data=" + data +
                '}';
    }
}

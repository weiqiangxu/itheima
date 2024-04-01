package com.itheima.service;

import org.springframework.stereotype.Service;

@Service
public class School {

    private String Name = "GZ";
    public String GetName() {
        return Name;
    }
}

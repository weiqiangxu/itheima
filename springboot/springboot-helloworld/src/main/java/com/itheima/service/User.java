package com.itheima.service;

import org.springframework.stereotype.Service;

@Service
public class User {

    private final School school;

    public String Name;

    public void SetName(String name){
        Name = name;
    }

    public User(School school){
        this.school = school;
    }

    public String GetSchoolName() {
        return this.school.GetName();
    }

    public String GetName() {
        return Name;
    }
}

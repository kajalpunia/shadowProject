package com.trainingapps.jobms.jobms.dto;

/**
 *
 *   Recruiter details class
 */

public class RecruiterDetails {

    long id;
    String name;
    String company;
    int age;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }
}

package com.trainingapps.recruiterms.dto;

/**
 *
 *  dto class for adding recruiter request
 */

public class AddRecruiterRequest {

    private String name;
    private int age;
    private String company;

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

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }
}

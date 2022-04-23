package com.trainingapps.jobms.jobms.dto;

import java.util.Objects;

/**
 *   dto class for job details
 */

public class JobDetails {

    private long id;
    private String name;
    private int age;
    private String jobType;
    private String description;
    private String company;

    public JobDetails(){}

    public JobDetails(long id, String description, String type) {
        this.id = id;
        this.description = description;
        this.jobType = type;
    }

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

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getJobType() {

        return jobType;
    }

    public void setJobType(String jobType) {

        this.jobType = jobType;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDetails that = (JobDetails) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

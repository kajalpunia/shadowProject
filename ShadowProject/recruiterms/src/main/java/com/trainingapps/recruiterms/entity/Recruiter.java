package com.trainingapps.recruiterms.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 *   entity class with generated id and table: recruiter_info
 */

@Table(name = "recruiter_info")
@Entity
public class Recruiter {

    @GeneratedValue
    @Id
    private long id;
    private String name;
    private int age;
    private String company;

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
        Recruiter recruiter = (Recruiter) o;
        return id == recruiter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.trainingapps.jobms.jobms.entity;

import com.trainingapps.jobms.jobms.constant.JobType;

import javax.persistence.*;
import java.util.Objects;

/**
 *   entity class for job with generated id and table job_info
 */

@Table(name = "job_info")
@Entity
public class Job {

    @GeneratedValue
    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    private JobType type;

    private String description;
    private Long createdBy;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public JobType getType() {

        return type;
    }

    public void setType(JobType type) {

        this.type = type;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Long getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {

        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}



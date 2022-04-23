package com.trainingapps.jobms.jobms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 *
 *   dto class for adding job request
 */
public class AddJobRequest {

    @Length(min = 1,max = 100)
    private String description;

    @NotBlank
    private String type;

    private Long createdBy;


    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public Long getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {

        this.createdBy = createdBy;
    }
}

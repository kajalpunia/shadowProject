package com.trainingapps.jobms.jobms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 *  dto class for changing the job type
 */

public class ChangeJobType {

    @Min(1)
    private long id;

    @Length(min = 1,max = 100)
    private String description;

    @NotBlank
    private String type;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

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
}

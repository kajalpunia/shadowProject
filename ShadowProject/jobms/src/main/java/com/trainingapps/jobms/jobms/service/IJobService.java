package com.trainingapps.jobms.jobms.service;

import com.trainingapps.jobms.jobms.dto.AddJobRequest;
import com.trainingapps.jobms.jobms.dto.ChangeJobType;
import com.trainingapps.jobms.jobms.dto.JobDetails;
import com.trainingapps.jobms.jobms.entity.Job;
import com.trainingapps.jobms.jobms.exceptions.InvalidJobTypeException;
import com.trainingapps.jobms.jobms.exceptions.JobNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

//Interface for service class
@Validated
public interface IJobService {

    JobDetails addJob(@Valid AddJobRequest requestData) throws InvalidJobTypeException;

    Job findById(@Min(1) long id) throws JobNotFoundException;

    JobDetails findJobDetailsById(@Min(1) long id) throws JobNotFoundException;

    JobDetails changeJobType(ChangeJobType requestdata) throws JobNotFoundException,InvalidJobTypeException;
}

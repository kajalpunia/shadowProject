package com.trainingapps.recruiterms.service;

import com.trainingapps.recruiterms.dto.AddRecruiterRequest;
import com.trainingapps.recruiterms.dto.RecruiterDetails;
import com.trainingapps.recruiterms.exceptions.RecruiterNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

//Interface for recruiter service class
@Validated
public interface IRecruiterService {

    RecruiterDetails addRecruiter(@Valid AddRecruiterRequest request);

    RecruiterDetails findRecruiterDetailsById(@Min(1) long recruiterId) throws RecruiterNotFoundException;
}

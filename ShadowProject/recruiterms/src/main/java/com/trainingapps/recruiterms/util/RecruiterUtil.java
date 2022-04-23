package com.trainingapps.recruiterms.util;

import com.trainingapps.recruiterms.dto.RecruiterDetails;
import com.trainingapps.recruiterms.entity.Recruiter;
import org.springframework.stereotype.Component;

/**
 *   util class for conversion to recruiter details
 */
@Component
public class RecruiterUtil {

    public RecruiterDetails toRecruiterDetails(Recruiter recruiter){

        RecruiterDetails details = new RecruiterDetails();
        details.setId(recruiter.getId());
        details.setName(recruiter.getName());
        details.setCompany(recruiter.getCompany());
        details.setAge(recruiter.getAge());

        return  details;
    }
}

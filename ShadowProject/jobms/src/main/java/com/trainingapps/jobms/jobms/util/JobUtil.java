package com.trainingapps.jobms.jobms.util;

import com.trainingapps.jobms.jobms.constant.JobType;
import com.trainingapps.jobms.jobms.dto.JobDetails;
import com.trainingapps.jobms.jobms.dto.RecruiterDetails;
import com.trainingapps.jobms.jobms.entity.Job;
import com.trainingapps.jobms.jobms.exceptions.InvalidJobTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 *   util class for conversion to jobDetails and jobType to enum
 */
@Component
public class JobUtil {

    @Value("${recruiter.baseUrl}")
    private String baseRecruiterUrl;

    @Autowired
    private RestTemplate restTemplate;

    public JobDetails toJobDetails(Job job){

        Long recruiterId = job.getId();
        JobType jobType = job.getType();
        String jobText = jobType.toString();
        JobDetails desiredOutput = new JobDetails(job.getId(),job.getDescription(),jobText);

        if(recruiterId != null){
            RecruiterDetails recruiter = fetchRecruiterById(recruiterId);
            desiredOutput.setId(recruiterId);
            desiredOutput.setName(recruiter.getName());
            desiredOutput.setCompany(recruiter.getCompany());
            desiredOutput.setAge(recruiter.getAge());
        }
        return desiredOutput;
    }

    public JobType toEnum(String typeText) throws InvalidJobTypeException {
        JobType values[] = JobType.values();
        for(JobType iterated : values) {
            String iteratedText = iterated.toString();
            if(iteratedText.equalsIgnoreCase(typeText)) {
                return iterated;
            }
        }
        throw new InvalidJobTypeException("Job Type is Invalid");
    }


    public RecruiterDetails fetchRecruiterById(Long recruiterId){
        String url = baseRecruiterUrl+"/byid/"+recruiterId;
        RecruiterDetails details = restTemplate.getForObject(url,RecruiterDetails.class);
        return details;
    }
}




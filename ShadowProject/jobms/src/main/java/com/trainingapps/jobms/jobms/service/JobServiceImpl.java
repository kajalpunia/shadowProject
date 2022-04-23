package com.trainingapps.jobms.jobms.service;

import com.trainingapps.jobms.jobms.constant.JobType;
import com.trainingapps.jobms.jobms.dto.AddJobRequest;
import com.trainingapps.jobms.jobms.dto.ChangeJobType;
import com.trainingapps.jobms.jobms.dto.JobDetails;
import com.trainingapps.jobms.jobms.entity.Job;
import com.trainingapps.jobms.jobms.exceptions.InvalidJobTypeException;
import com.trainingapps.jobms.jobms.exceptions.JobNotFoundException;
import com.trainingapps.jobms.jobms.repository.IJobRepository;
import com.trainingapps.jobms.jobms.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Validated
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private IJobRepository repository;

    /**
     *   method to add new job details
     */

    @Transactional
    @Override
    public JobDetails addJob(AddJobRequest requestData) throws InvalidJobTypeException {
        Job job = new Job();
        job.setDescription(requestData.getDescription());
        job.setCreatedBy(requestData.getCreatedBy());
        String type = requestData.getType();
        JobType jobType = jobUtil.toEnum(type);
        job.setType(jobType);

        job = repository.save(job);
        JobDetails response = jobUtil.toJobDetails(job);
        return response;
    }


    /**
     *    method to find job by id
     */

    @Override
    public Job findById(long id) throws JobNotFoundException {
        Optional<Job> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new JobNotFoundException("job not found");
        }

        Job desired = optional.get();
        return desired;
    }
    @Override
    public JobDetails findJobDetailsById(long id) throws JobNotFoundException {
        Job job = findById(id);
        JobDetails response = jobUtil.toJobDetails(job);
        return response;
    }


    /**
     *   method to update the job type
     */

    @Transactional
    @Override
    public JobDetails changeJobType(ChangeJobType requestdata) throws JobNotFoundException, InvalidJobTypeException {
        Job job = findById(requestdata.getId());
        String newJobType = requestdata.getType();
        JobType jobType = jobUtil.toEnum(newJobType);
        job.setType(jobType);
        job = repository.save(job);
        JobDetails response = jobUtil.toJobDetails(job);
        return response;
    }
}

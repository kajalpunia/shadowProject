package com.trainingapps.jobms.jobms.controller;

import com.trainingapps.jobms.jobms.dto.AddJobRequest;
import com.trainingapps.jobms.jobms.dto.ChangeJobType;
import com.trainingapps.jobms.jobms.dto.JobDetails;
import com.trainingapps.jobms.jobms.service.IJobService;
import com.trainingapps.jobms.jobms.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 *   Controller class , with rest points for:
 *   adding jobs : /jobs/add
 *   fetching jobs by id: /jobs/byid/{id}
 *   updating: /jobs/update
 *
 */

@RequestMapping("/jobs")
@RestController
public class JobController {

    @Autowired
    private IJobService service;

    @Autowired
    private JobUtil jobUtil;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public JobDetails addJob(@RequestBody AddJobRequest requestData) throws Exception{
        JobDetails response = service.addJob(requestData);
        return response;
    }

    @GetMapping("/byid/{id}")
    public JobDetails findById(@PathVariable int id) throws Exception{
        JobDetails response = service.findJobDetailsById(id);
        return response;
    }

    @PutMapping("/update")
    public  JobDetails changeJobType(@RequestBody ChangeJobType requestData) throws Exception{
        JobDetails response = service.changeJobType(requestData);
        return response;
    }

}

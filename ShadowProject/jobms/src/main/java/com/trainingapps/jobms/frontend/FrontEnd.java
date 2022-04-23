package com.trainingapps.jobms.frontend;


import com.trainingapps.jobms.jobms.dto.AddJobRequest;
import com.trainingapps.jobms.jobms.dto.JobDetails;
import com.trainingapps.jobms.jobms.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//FrontEnd class was used for manual testing purpose
@Component
public class FrontEnd {

    @Autowired
    IJobService service;

    public void runUI(){

        try{

            System.out.println("Adding jobs:");

            /*------adding job1 ------*/

            AddJobRequest request1 = new AddJobRequest();
            request1.setDescription("Dev job is related to development related tasks.");
            request1.setType("DEV");

            JobDetails job1 = service.addJob(request1);
            System.out.println("job 1:");
            display(job1);

            /*------adding job 2------*/

            AddJobRequest request2 = new AddJobRequest();
            request2.setDescription("Testing job is related to manual and automation testing.");
            request2.setType("Testing");

            JobDetails job2 = service.addJob(request2);
            System.out.println("job 2:");
            display(job2);

            System.out.println("**** displaying jobs by id ****");
            long jobId1 = job1.getId();
            JobDetails job=service.findJobDetailsById(jobId1);
            System.out.println("Finding jobs by id "+jobId1);
            display(job);

        }catch (Exception e){

            e.printStackTrace();

        }
     }

     void display(JobDetails job){

         System.out.println("id : "+ job.getId() +". Job Type : "+job.getJobType()+", job description : " +job.getDescription());

     }

}

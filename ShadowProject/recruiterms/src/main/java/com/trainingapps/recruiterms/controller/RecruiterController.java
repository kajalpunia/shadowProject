package com.trainingapps.recruiterms.controller;

import com.trainingapps.recruiterms.dto.AddRecruiterRequest;
import com.trainingapps.recruiterms.dto.RecruiterDetails;
import com.trainingapps.recruiterms.exceptions.RecruiterNotFoundException;
import com.trainingapps.recruiterms.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *   controller class with rest end points for:-
 *   creating recruiter: /recruiters/create
 *   fetching recruiter by id: /byid/{id}
 */

@RequestMapping("/recruiters")
@RestController
public class RecruiterController {

    @Autowired
    private IRecruiterService service;

    @PostMapping("/create")
    public RecruiterDetails createRecruiter(@RequestBody AddRecruiterRequest request){
        return service.addRecruiter(request);

    }

    @GetMapping("/byid/{id}")
    public RecruiterDetails findById(@PathVariable long id) throws RecruiterNotFoundException {
        return service.findRecruiterDetailsById(id);
    }
}

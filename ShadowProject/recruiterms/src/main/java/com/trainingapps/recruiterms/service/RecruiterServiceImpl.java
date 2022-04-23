package com.trainingapps.recruiterms.service;

import com.trainingapps.recruiterms.dto.AddRecruiterRequest;
import com.trainingapps.recruiterms.dto.RecruiterDetails;
import com.trainingapps.recruiterms.entity.Recruiter;
import com.trainingapps.recruiterms.exceptions.RecruiterNotFoundException;
import com.trainingapps.recruiterms.repository.IRecruiterRepository;
import com.trainingapps.recruiterms.util.RecruiterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RecruiterServiceImpl implements IRecruiterService {

    @Autowired
    private IRecruiterRepository repository;

    @Autowired
    private RecruiterUtil recruiterUtil;

    @Override
    public RecruiterDetails addRecruiter(AddRecruiterRequest request) {
        Recruiter recruiter = new Recruiter();
        recruiter.setName(request.getName());
        recruiter.setCompany(request.getCompany());
        recruiter.setAge(request.getAge());
        recruiter = repository.save(recruiter);
        RecruiterDetails desired = recruiterUtil.toRecruiterDetails(recruiter);
        return desired;
    }

    public Recruiter findById(long id) throws RecruiterNotFoundException {

        Optional<Recruiter> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RecruiterNotFoundException("Recruiter not found");
        }

        return optional.get();
    }

    @Override
    public RecruiterDetails findRecruiterDetailsById(long recruiterId) throws RecruiterNotFoundException {
        Recruiter recruiter = findById(recruiterId);
        RecruiterDetails desired = recruiterUtil.toRecruiterDetails(recruiter);
        return desired;
    }
}

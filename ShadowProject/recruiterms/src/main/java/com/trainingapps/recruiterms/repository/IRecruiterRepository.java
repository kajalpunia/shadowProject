package com.trainingapps.recruiterms.repository;

import com.trainingapps.recruiterms.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecruiterRepository extends JpaRepository<Recruiter,Long> {
}

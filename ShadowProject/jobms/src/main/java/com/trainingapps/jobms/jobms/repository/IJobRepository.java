package com.trainingapps.jobms.jobms.repository;

import com.trainingapps.jobms.jobms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<Job,Long> {
}

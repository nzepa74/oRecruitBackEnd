package com.spring.boot.development.sa.repository;

import com.spring.boot.development.project.model.JobSeekerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By zepaG on 6/9/2022.
 */
public interface JobSeekerInfoRepo extends JpaRepository<JobSeekerInfo, String> {
}

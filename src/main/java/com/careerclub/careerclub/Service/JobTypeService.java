package com.careerclub.careerclub.Service;

import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.DTOs.JobTypeRequest;
import com.careerclub.careerclub.Entities.EmploymentType;
import com.careerclub.careerclub.Repositories.JobTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeService {
    private final JobTypeRepository jobTypeRepository;
    private  JobTypeEnums jobTypeEnums;

    public JobTypeService(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    public List<EmploymentType> getAllJobs(){
        var jobTypes = jobTypeRepository.findAll();
        return jobTypes;
    }
    public EmploymentType createJobType(JobTypeRequest jobTypeRequest){
        EmploymentType jobType = new EmploymentType();
        checkingEnums(jobTypeRequest.getName());
        do{
            jobType.setName(jobTypeRequest.getName());
            jobTypeRepository.save(jobType);
            return jobType;
        } while(true);

    }
    public enum JobTypeEnums {
        FULLTIME,
        REMOTE,
        HYBRID,
        CONTRACT,
        INTERNSHIP
    }
    public boolean checkingEnums(String name){
        var jobtype = jobTypeRepository.getByname(name.toUpperCase());
        if (jobtype != null){
            throw new RecordNotFoundException("Job type exists");
        }else{
            if(name.toUpperCase().equals(JobTypeEnums.FULLTIME.name())){
                return true;
            } else if (name.toUpperCase().equals(JobTypeEnums.REMOTE.name())) {
                return true;
            } else if (name.toUpperCase().equals(JobTypeEnums.CONTRACT.name())) {
                return true;
            } else if (name.toUpperCase().equals(JobTypeEnums.HYBRID.name())) {
                return true;
            } else if (name.toUpperCase().equals(JobTypeEnums.INTERNSHIP.name())) {
                return true;
            }else {
                throw new RecordNotFoundException("Job type is invalid");
            }
        }

    }

}

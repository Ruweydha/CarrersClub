package com.careerclub.careerclub.SavedJobs.service;


import com.careerclub.careerclub.Advice.DuplicateException;
import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.Repositories.JobRepository;
import com.careerclub.careerclub.Repositories.UserRepository;
import com.careerclub.careerclub.SavedJobs.entity.SavedJobs;
import com.careerclub.careerclub.SavedJobs.repository.SavedJobRepository;
import com.careerclub.careerclub.Utils.UserCheck;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SavedJobService {
    private final SavedJobRepository savedJobRepository;
    private final UserRepository userRepository;

    private final JobRepository jobRepository;

    public SavedJobService(SavedJobRepository savedJobRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.savedJobRepository = savedJobRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }


    public List<SavedJobs> getAllUserSavedJobs(){
        var userCheck = new UserCheck(userRepository);
        var user = userCheck.getUserFromToken();
        return savedJobRepository.findAllByUserId(user.getId());

    }

    public SavedJobs saveJob(Long jobId){
        var userCheck = new UserCheck(userRepository);
        var user = userCheck.getUserFromToken();
        var savedJob = savedJobRepository.findByUserIdAndJobId(user.getId(),jobId);
        var jobSaved = new SavedJobs();
        if(savedJob.isEmpty()){
            var job = jobRepository.getReferenceById(jobId);
            jobSaved.setJob(job);
            jobSaved.setUser(user);
            savedJobRepository.save(jobSaved);
        }else{
            throw new DuplicateException("You have already saved this job");
        }
        return jobSaved;
    }

    public HashMap<Object,Object> unSaveJob(Long jobId){
        var validate = new HashMap<>();
        var userCheck = new UserCheck(userRepository);
        var user = userCheck.getUserFromToken();
        var jobSaved = savedJobRepository.findByUserIdAndJobId(user.getId(),jobId);
        jobSaved.ifPresentOrElse(j->{
            savedJobRepository.delete(j);
            validate.put("message","Job unsaved successfully");
        },()->{
            throw new RecordNotFoundException("Job with the given id doesn't exist");
        });

        return validate;
    }

}

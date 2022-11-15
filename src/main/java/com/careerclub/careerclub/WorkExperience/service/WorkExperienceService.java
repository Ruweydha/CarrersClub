package com.careerclub.careerclub.WorkExperience.service;

import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.Repositories.UserRepository;
import com.careerclub.careerclub.Utils.Dateformat;
import com.careerclub.careerclub.WorkExperience.dto.WorkExperienceRequest;
import com.careerclub.careerclub.WorkExperience.entity.WorkExperience;
import com.careerclub.careerclub.WorkExperience.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class WorkExperienceService {
    private final WorkExperienceRepository workExperienceRepository;
    private final UserRepository userRepository;

    public WorkExperienceService(WorkExperienceRepository workExperienceRepository, UserRepository userRepository) {
        this.workExperienceRepository = workExperienceRepository;
        this.userRepository = userRepository;
    }
    public WorkExperience addWorkExperience(WorkExperienceRequest workExperienceRequest) throws ParseException {
        var workExperience = new WorkExperience();
        var user = userRepository.findById(workExperienceRequest.getUserId());
        user.ifPresentOrElse(user1 -> {
            workExperience.setUser(user1);
        }, ()->{
            throw new RecordNotFoundException("Given user doesn't exist");
        });
        workExperience.setEmployer(workExperienceRequest.getEmployer());
        workExperience.setJobTitle(workExperienceRequest.getJobTitle());
        workExperience.setDescription(workExperienceRequest.getDescription());
        workExperience.setJobCategory(workExperienceRequest.getJobCategory());
        workExperience.setStartOfJob(Dateformat.formatDate(workExperienceRequest.getStartOfJob()));
        workExperience.setEndOfJob(Dateformat.formatDate(workExperienceRequest.getEndOfJob()));
        workExperience.setUrlOfEmployer(workExperienceRequest.getUrlOfEmployer());
        workExperienceRepository.save(workExperience);
        return workExperience;
    }

    public Optional<WorkExperience> updateWorkExperience(Long id, WorkExperienceRequest workExperienceRequest){
        var workExperience = workExperienceRepository.findById(id);
        workExperience.ifPresentOrElse(w ->{
            w.setUrlOfEmployer(workExperienceRequest.getUrlOfEmployer());
            w.setEmployer(workExperienceRequest.getEmployer());
            w.setJobTitle(workExperienceRequest.getJobTitle());
            workExperienceRepository.save(w);
        }, ()->{
            throw new RecordNotFoundException("Work experience doesn't exist");
        });
        return workExperience;
    }
}

package com.careerclub.careerclub.Education.service;

import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.Education.dto.EducationCreateRequest;
import com.careerclub.careerclub.Education.entity.Education;
import com.careerclub.careerclub.Education.repository.EducationRepository;
import com.careerclub.careerclub.Repositories.UserRepository;
import com.careerclub.careerclub.Utils.Dateformat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final UserRepository userRepository;

    public EducationService(EducationRepository educationRepository, UserRepository userRepository) {
        this.educationRepository = educationRepository;
        this.userRepository = userRepository;
    }

    public List<Education> getAllUserEducations(Long userId){
        return educationRepository.findAllByUserId(userId);
    }

    public Education addEducation(EducationCreateRequest educationCreateRequest) throws ParseException{
        var user = userRepository.findById(educationCreateRequest.getUserId());
        var startOfEducation = Dateformat.formatDate(educationCreateRequest.getStartOfEducation());
        var endOfEducation = Dateformat.formatDate(educationCreateRequest.getEndOfEducation());
        var education = new Education();
        education.setSchoolName(educationCreateRequest.getSchoolName());
        education.setDegreeName(educationCreateRequest.getDegreeName());
        education.setEducationLevel(educationCreateRequest.getEducationLevel());
        education.setGrade(educationCreateRequest.getGrade());
        education.setStartOfEducation(startOfEducation);
        education.setEndOfEducation(endOfEducation);

        user.ifPresentOrElse(u->{
            education.setUser(u);
            educationRepository.save(education);
        },()->{
            throw new RecordNotFoundException("User with the given id doesn't exist");
        });

        return education;
    }

    public Optional<Education> updateEducation(Long educationId, EducationCreateRequest educationCreateRequest) throws ParseException{
        var education = educationRepository.findById(educationId);
        var startOfEducation = Dateformat.formatDate(educationCreateRequest.getStartOfEducation());
        var endOfEducation = Dateformat.formatDate(educationCreateRequest.getEndOfEducation());
        education.ifPresentOrElse(e->{
            e.setSchoolName(educationCreateRequest.getSchoolName());
            e.setDegreeName(educationCreateRequest.getDegreeName());
            e.setEducationLevel(educationCreateRequest.getEducationLevel());
            e.setGrade(educationCreateRequest.getGrade());
            e.setStartOfEducation(startOfEducation);
            e.setEndOfEducation(endOfEducation);
            educationRepository.save(e);
        },()->{
            throw new RecordNotFoundException("Education with the given id doesn't exist.");
        });
        return education;
    }

    public HashMap<Object,Object> deleteEducation(Long educationId){
        var validate = new HashMap<>();
        var education = educationRepository.findById(educationId);
        education.ifPresentOrElse(e->{
            educationRepository.delete(e);
            validate.put("message","Education deleted successfully");
        },()->{
            throw new RecordNotFoundException("Education with the given id doesn't exist");
        });
        return validate;
    }

}

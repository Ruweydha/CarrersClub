package com.careerclub.careerclub.Education.controller;

import com.careerclub.careerclub.Education.dto.EducationCreateRequest;
import com.careerclub.careerclub.Education.entity.Education;
import com.careerclub.careerclub.Education.service.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Education>> getAllUserEducations(@PathVariable Long userId){
        var educations = educationService.getAllUserEducations(userId);
        return ResponseEntity.ok(educations);
    }

    @PostMapping("/add")
    public ResponseEntity<Education> addEducation(@RequestBody EducationCreateRequest educationCreateRequest){
        var education = educationService.addEducation(educationCreateRequest);
        return ResponseEntity.status(201).body(education);
    }

    @PutMapping("/update/{educationId}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long educationId,@RequestBody EducationCreateRequest educationCreateRequest){
        var education = educationService.updateEducation(educationId,educationCreateRequest);
        return ResponseEntity.of(education);
    }

    @DeleteMapping("/delete/{educationId}")
    public ResponseEntity<HashMap<Object,Object>> deleteEducation(@PathVariable Long educationId){
        var message = educationService.deleteEducation(educationId);
        return ResponseEntity.ok(message);
    }

}

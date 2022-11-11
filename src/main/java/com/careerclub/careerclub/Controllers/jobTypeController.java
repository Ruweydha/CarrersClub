package com.careerclub.careerclub.Controllers;

import com.careerclub.careerclub.DTOs.JobTypeRequest;
import com.careerclub.careerclub.Entities.EmploymentType;
import com.careerclub.careerclub.Service.JobTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Job Type controller")
@RestController
@RequestMapping("/jobtype")
public class jobTypeController {
    private final JobTypeService jobTypeService;

    public jobTypeController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    @GetMapping
    public ResponseEntity<List<EmploymentType>> getAllJobTypes(){
        var types = jobTypeService.getAllJobs();
        return ResponseEntity.ok(types);
    }
    @PostMapping
    public ResponseEntity<EmploymentType> postJobType(@RequestBody JobTypeRequest jobTypeRequest){
        return ResponseEntity.ok(jobTypeService.createJobType(jobTypeRequest));
    }
}

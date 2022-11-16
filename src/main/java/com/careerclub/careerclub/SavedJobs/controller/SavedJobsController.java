package com.careerclub.careerclub.SavedJobs.controller;


import com.careerclub.careerclub.DTOs.SaveJobRequest;
import com.careerclub.careerclub.SavedJobs.service.SavedJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("save-job")
public class SavedJobsController {

    private final SavedJobService savedJobService;

    public SavedJobsController(SavedJobService savedJobService) {
        this.savedJobService = savedJobService;
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllUserSavedJobs(){
        var jobs = savedJobService.getAllUserSavedJobs();
        return ResponseEntity.ok(jobs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveJob(@RequestBody SaveJobRequest saveJobRequest){
        var savedJob = savedJobService.saveJob(saveJobRequest.getJobId());
        return ResponseEntity.ok(savedJob);
    }

    @DeleteMapping("/unsave/{jobId}")
    public ResponseEntity<?> unSaveJob(@PathVariable Long jobId){
        var message = savedJobService.unSaveJob(jobId);
        return ResponseEntity.ok(message);
    }

}

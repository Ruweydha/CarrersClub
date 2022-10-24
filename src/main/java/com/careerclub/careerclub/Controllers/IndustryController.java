package com.careerclub.careerclub.Controllers;

import com.careerclub.careerclub.DTOs.IndustryCreationRequest;
import com.careerclub.careerclub.DTOs.IndustryUpdateRequest;
import com.careerclub.careerclub.Entities.Industry;
import com.careerclub.careerclub.Service.IndustryService;
import com.careerclub.careerclub.Utils.ErrorConverter;
import com.careerclub.careerclub.Utils.IndustryValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("industries")
public class IndustryController {
    private final IndustryService industryService;
    private final IndustryValidator industryValidator;


    public IndustryController(IndustryService industryService, IndustryValidator industryValidator) {
        this.industryService = industryService;
        this.industryValidator = industryValidator;
    }


    @GetMapping
    public ResponseEntity<List<Industry>> getAllIndustries(){
        var industries = industryService.getAllIndustries();
        return ResponseEntity.ok(industries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Industry> getIndustryById(@PathVariable Long id){
        var industry = industryService.getIndustryById(id);
        return ResponseEntity.of(industry);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Industry> getSingleIndustryByName(@PathVariable String name){
        var industry = industryService.getIndustryByName(name);
        return ResponseEntity.of(industry);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createIndustry(@Valid @RequestBody IndustryCreationRequest industryCreationRequest, BindingResult errors){
        industryValidator.validate(industryCreationRequest,errors);
        if(!errors.hasErrors()){
            var industry = industryService.createIndustry(industryCreationRequest);
            return ResponseEntity.ok(industry);
        }
        return ResponseEntity.badRequest().body(ErrorConverter.convert(errors));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateIndustry(@PathVariable Long id, @RequestBody IndustryCreationRequest industryCreationRequest, BindingResult errors){
        industryValidator.validate(industryCreationRequest,errors);
        if(!errors.hasErrors()){
            var industry = industryService.updateIndustry(id, industryCreationRequest);
            return ResponseEntity.of(industry);
        }
        return ResponseEntity.badRequest().body(ErrorConverter.convert(errors));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<HashMap<Object,Object>> deleteIndustry(@PathVariable String name){
        var message = industryService.deleteIndustry(name);
        return ResponseEntity.ok(message);
    }


}
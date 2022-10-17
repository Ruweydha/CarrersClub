package com.careerclub.careerclub.Service;
import com.careerclub.careerclub.Advice.RecordNotFoundException;
import com.careerclub.careerclub.DTOs.CompanyUpdateRequest;
import com.careerclub.careerclub.Entities.Company;
import com.careerclub.careerclub.DTOs.CompanyCreationRequest;
import com.careerclub.careerclub.Repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        var companies = companyRepository.findAll();
        return companies;
    }

    public Optional<Company> getCompanyById(Long id){
        var company = companyRepository.findById(id);
        return company;
    }

    public Company createCompany(CompanyCreationRequest newCompany){
        var company = new Company();
        company.setName(newCompany.getName());
        company.setDescription(newCompany.getDescription());
        company.setLink(newCompany.getLink());
        companyRepository.save(company);
        return company;
    }

    public Optional<Company> updateCompany(Long id, CompanyUpdateRequest companyUpdateRequest){
        var companyRecord = companyRepository.findById(id);
        companyRecord.ifPresentOrElse(company -> {
            company.setName(companyUpdateRequest.getName());
            company.setDescription(companyUpdateRequest.getDescription());
            company.setLink(companyUpdateRequest.getLink());
            companyRepository.save(company);
        },()->{
            throw new RecordNotFoundException("Company not found");
        });
        return companyRecord;
    }
    public String deleteCompany(Long id){
        var companyRecord = companyRepository.findById(id);
        companyRecord.ifPresentOrElse(company -> {
            companyRepository.delete(company);
        },()->{
            throw new RecordNotFoundException("Company not found");
        });
        return "Company deleted";
    }
}


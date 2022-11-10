package com.careerclub.careerclub.Industry;


import com.careerclub.careerclub.Controllers.IndustryController;
import com.careerclub.careerclub.DTOs.IndustryCreationRequest;
import com.careerclub.careerclub.DTOs.IndustryUpdateRequest;
import com.careerclub.careerclub.Entities.Industry;
import com.careerclub.careerclub.Repositories.IndustryRepository;
import com.careerclub.careerclub.Service.CustomUserDetailsService;
import com.careerclub.careerclub.Service.IndustryService;
import com.careerclub.careerclub.Utils.IndustryValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {IndustryController.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class IndustryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    IndustryService industryService;

    @MockBean
    IndustryValidator industryValidator;

    @MockBean
    CustomUserDetailsService customUserDetailsService;

    @MockBean
    IndustryRepository industryRepository;

    @Test
    @DisplayName("Testing all industries endpoint")
    @WithMockUser
    public void test_all_industry_endpoint() throws Exception {
        when(industryService.getAllIndustries()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/industries")).andExpect(status().isOk());
        verify(industryService).getAllIndustries();
    }



    @Test
    @DisplayName("testing endpoint to create an industry")
    @WithMockUser
    public void test_industry_create() throws Exception {
        var industry = new IndustryCreationRequest();
        industry.setName("hacking");
        String ind = objectMapper.writeValueAsString(industry);
        when(industryService.createIndustry(any(IndustryCreationRequest.class))).thenReturn(new Industry());
        mockMvc.perform(post("/industries/create")
                .content(ind)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        verify(industryService).createIndustry(any(IndustryCreationRequest.class));
    }

    @Test
    @DisplayName("testing endpoint for updating an industry")
    @WithMockUser
    public void test_industry_update() throws Exception{
        var industry = new IndustryCreationRequest();
        industry.setName("IT");
        String ind = objectMapper.writeValueAsString(industry);
        when(industryService.updateIndustry(any(Long.class),any(IndustryCreationRequest.class))).thenReturn(Optional.of(new Industry()));
        mockMvc.perform(put("/industries/update/{id}",1)
                .content(ind)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(industryService).updateIndustry(any(Long.class),any(IndustryCreationRequest.class));
    }

    @Test
    @DisplayName("testing delete endpoint for a single industry")
    @WithMockUser
    public void test_industry_delete() throws Exception{
        when(industryService.deleteIndustry(any(Long.class))).thenReturn(new HashMap<>());
        mockMvc.perform(delete("/industries/delete/{id}",1)).andExpect(status().isOk());
        verify(industryService).deleteIndustry(any(Long.class));
    }

}

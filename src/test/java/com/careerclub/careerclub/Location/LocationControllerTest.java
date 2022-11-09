package com.careerclub.careerclub.Location;


import com.careerclub.careerclub.Controllers.LocationController;
import com.careerclub.careerclub.DTOs.LocationCreateRequest;
import com.careerclub.careerclub.Entities.Location;
import com.careerclub.careerclub.Service.CustomUserDetailsService;
import com.careerclub.careerclub.Service.LocationService;
import com.careerclub.careerclub.Utils.LocationValidator;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {LocationController.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class LocationControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    LocationService locationService;

    @MockBean
    LocationValidator locationValidator;

    @MockBean
    CustomUserDetailsService customUserDetailsService;


    @Test
    @DisplayName("testing all locations endpoint")
    @WithMockUser
    public void test_all_locations() throws Exception{
        when(locationService.getAllLocations()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/locations")).andExpect(status().isOk());
        verify(locationService).getAllLocations();
    }

    @Test
    @DisplayName("testing location retrieval by id endpoint")
    @WithMockUser
    public void test_location_get_id() throws Exception{
        when(locationService.getLocationById(any(Long.class))).thenReturn(Optional.of(new Location()));
        mockMvc.perform(MockMvcRequestBuilders.get("/locations/{id}",1)).andExpect(status().isOk());
        verify(locationService).getLocationById(any(Long.class));
    }


    @Test
    @DisplayName("testing location creation endpoint")
    @WithMockUser
    public void test_location_creation() throws Exception{
        var location = new LocationCreateRequest();
        location.setName("naivasha");
        String lct = objectMapper.writeValueAsString(location);
        when(locationService.createLocation(any(LocationCreateRequest.class))).thenReturn(new Location());
        mockMvc.perform(MockMvcRequestBuilders.post("/locations/create")
                .content(lct)
                .contentType(MediaType.APPLICATION_JSON
                )).andExpect(status().isCreated());
        verify(locationService).createLocation(any(LocationCreateRequest.class));
    }

    @Test
    @DisplayName("testing location update endpoint")
    @WithMockUser
    public void test_location_update() throws Exception{
        var location = new LocationCreateRequest();
        location.setName("kajiado");
        String lct = objectMapper.writeValueAsString(location);
        when(locationService.updateLocation(any(Long.class),any(LocationCreateRequest.class))).thenReturn(Optional.of(new Location()));
        mockMvc.perform(MockMvcRequestBuilders.put("/locations/update/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(lct)).andExpect(status().isOk());
        verify(locationService).updateLocation(any(Long.class),any(LocationCreateRequest.class));
    }


}

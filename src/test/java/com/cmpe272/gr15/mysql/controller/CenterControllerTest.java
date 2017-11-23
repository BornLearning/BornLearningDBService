package com.cmpe272.gr15.mysql.controller;


import com.cmpe272.gr15.mysql.fixture.CenterFixture;
import com.cmpe272.gr15.mysql.model.dto.Center;
import com.cmpe272.gr15.mysql.service.CenterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class CenterControllerTest extends BornLearningControllerTest<Center, CenterService> {

    private MockMvc mockMvc;

    @Mock
    private CenterService mockCenterService;

    @InjectMocks
    private CenterController centerController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(centerController).build();
    }

    @Test
    public void itShoudGetFacilitatorById() throws Exception {
        Center center1 = CenterFixture.generateValidCenter();
        Center center2 = CenterFixture.generateValidCenter();

        when(mockCenterService.getAll()).thenReturn(Arrays.asList(center1, center2));

        mockMvc.perform(get("/centers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)));
    }
}

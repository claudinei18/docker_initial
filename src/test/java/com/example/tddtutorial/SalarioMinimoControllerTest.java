package com.example.tddtutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SalarioMinimoControllerTest extends TddTutorialApplicationTests {


    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SalarioMinimoController salarioMinimoController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(salarioMinimoController).build();
    }

    @Test
    public void testGETIndexSalarioMinimoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/salarios")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGETSaveSalarioMinimoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/salarios/novo"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("salarioMinimo"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPOSTSaveSalarioMinimoController() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/salarios")
                .param("estado", "BR")
                .param("salario", "800")
                .param("dataInicio", "01/01/2016")
                .param("dataFim", "02/02/2016")
        ).andExpect(MockMvcResultMatchers.redirectedUrl("/salarios/novo"));
    }


    /*@After
    public void tearDown() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "salarios_minimos");
    }*/


}

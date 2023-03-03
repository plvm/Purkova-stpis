package com.boots.controller;

import com.boots.entity.Kontrol;
import com.boots.entity.Objekt;
import com.boots.entity.Rabota;
import com.boots.entity.Smeta;
import com.boots.service.KontrolService;
import com.boots.service.RabotaService;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KontrolControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private KontrolService kontrolService;
    @Autowired
    private RabotaService rab;
    @Autowired
    private KontrolController kon;
    @Autowired
    private MockMvc mockMvc;

    @Test
  public   void homeee() throws Exception {

        List<Kontrol> listKon =kon.homee();
                assertEquals( 1,listKon.size());

    }
  /*  public   void homee() throws Exception {
       double d = 9;
        Kontrol kontrol = new Kontrol();
        kontrol.setNumberkontrol(13L);
        kontrol.setNumberobjekt(1111L);
        kontrol.setNumberrabota(1111L);
        kontrol.setKolvo(23L);
        kontrol.setKolvoost(222L);
        kontrol.setPrice(87.0);
        kontrol.setDate("январь 2022");
        kontrol.setSumma(2001.0);

        Mockito.when(kontrolService.listAll()).thenReturn(Arrays.asList(kontrol));
        mockMvc.perform(
                get("/kontroll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(kontrol))));
        ;
    }*/


    @Test
   public   void  searchCustomerrForm()throws Exception {
        List<Rabota> rabota=kon.searchCustomerrForm(1111L);

        assertEquals( 1,rabota.size());
    }
    @Test
    public   void  searchOObjektForm()throws IOException {
        List<Objekt> objekt=kon.searchOObjektForm(1111L);
        assertEquals( 1,objekt.size());
    }
    @Test
    public   void  saveKontrol()throws IOException {
        Kontrol kontrol = new Kontrol();
        kontrol.setNumberkontrol(13L);
        kontrol.setNumberobjekt(1111L);
        kontrol.setNumberrabota(1111L);
        kontrol.setKolvo(25L);
      //  kontrol.setKolvoost(222L);
        kontrol.setPrice(87.0);
        kontrol.setDate("январь 2022");
        //kontrol.setSumma(2001.0);
        String st= kon.saveKontrol(kontrol);
        assertEquals("save kontrol",st);
    }

    @Test
    public   void deleteKontrolForm()throws IOException {

        String st= kon.deleteKontrolForm(14L);
        assertEquals("delete kontrol",st);

    }

}
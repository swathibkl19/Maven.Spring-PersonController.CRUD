package io.zipcoder.crudapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private PersonRepository personRepository;

    @Test
        public void testShow() throws Exception {
            int givenId = 1;
            String firstname = "";
            String lastname = "";

            Person actual = new Person("anika",null,1);
            BDDMockito
                    .given(personRepository.findOne(givenId)).willReturn(actual);

         //  "{\"id\":null,\"name\":\"New Baker!\",\"employeeId\":null,\"specialty\":null}";

        String expectedContent =   "{\"firstname\":\"anika\",\"lastname\":null,\"id\":1}";
            this.mvc.perform(MockMvcRequestBuilders
                    .get("/people/" + givenId))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(expectedContent));
        }



    @Test

    public void getPerson() {
    }

    @Test
    public void getPersonList() {
    }

    @Test
    public void updatePerson() {
    }

    @Test
    public void deletePerson() {
    }
}
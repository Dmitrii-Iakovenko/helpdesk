package com.wutreg.helpdesk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wutreg.helpdesk.dto.EmployeeDTO;
import com.wutreg.helpdesk.entity.Employee;
import com.wutreg.helpdesk.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
//@WebMvcTest
class EmployeeControllerTest {

    private MockMvc mvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private JacksonTester<List<EmployeeDTO>> jsonListEmployeeDTO;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(employeeController)
            .build();
    }




    @Test
    void canRetrieveAllEmployees() throws Exception {
        // given
        List<Employee> EMPLOYEES = List.of(
            new Employee(1L, "Иван", "Иваныч", "Иванов", 1L, "Инженер", "100", "ivan@gmail.com", "+7 (495) 100-10-10", "+7 (909) 100-10-10", "1111"),
            new Employee(2L, "Олег", "Олегович", "Олегов", 2L, "Начальник отдела", "200", "oleg@mail.ru", "+7 (499) 200-20-20", "+7 (909) 200-20-20", "2222"),
            new Employee(3L, "Сергей", "Сергеевич", "Сергеев", 1L, "Программист", "300", "sergey@vk.com", "300-30-30", "+7 (909) 300-30-30", "3333")
        );
        String JSON_EMPLOYEES_DTO = "[{\"employeeId\":1,\"firstName\":\"Иван\",\"middleName\":\"Иваныч\",\"lastName\":\"Иванов\",\"departmentId\":1,\"jobPosition\":\"Инженер\",\"workLocation\":\"100\",\"email\":\"ivan@gmail.com\",\"cityPhone\":\"+7 (495) 100-10-10\",\"mobilePhone\":\"+7 (909) 100-10-10\",\"localPhone\":\"1111\"},{\"employeeId\":2,\"firstName\":\"Олег\",\"middleName\":\"Олегович\",\"lastName\":\"Олегов\",\"departmentId\":2,\"jobPosition\":\"Начальник отдела\",\"workLocation\":\"200\",\"email\":\"oleg@mail.ru\",\"cityPhone\":\"+7 (499) 200-20-20\",\"mobilePhone\":\"+7 (909) 200-20-20\",\"localPhone\":\"2222\"},{\"employeeId\":3,\"firstName\":\"Сергей\",\"middleName\":\"Сергеевич\",\"lastName\":\"Сергеев\",\"departmentId\":1,\"jobPosition\":\"Программист\",\"workLocation\":\"300\",\"email\":\"sergey@vk.com\",\"cityPhone\":\"300-30-30\",\"mobilePhone\":\"+7 (909) 300-30-30\",\"localPhone\":\"3333\"}]";
        given(employeeService.getAll()).willReturn(EMPLOYEES);

        // when
        MockHttpServletResponse response = mvc.perform(
            get("/api/v1/employees")
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString(StandardCharsets.UTF_8)).isEqualTo(JSON_EMPLOYEES_DTO);
    }

}
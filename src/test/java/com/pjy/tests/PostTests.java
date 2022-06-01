package com.pjy.tests;

import com.pjy.pojo.Employee;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static com.pjy.builder.RequestBuilder.*;
import static com.pjy.utils.RandomValuesUtils.*;

public class PostTests {

    @Test
    public void createEmployee(){
        Employee employee = Employee.builder()
                .setId(getId())
                .setFirstname(getFirstName())
                .setLastname(getLastName())
                .build();

        Response response = buildPostPayload()
                .body(employee)
                .post("/employees");
        response.prettyPrint();
        Assertions.assertThat(response.getStatusCode())
                .as("Validate the Status Code")
                .isEqualTo(201);
        Employee employee1 = response.as(Employee.class);
        Assertions.assertThat(employee1.getId())
                .as("Validate the id")
                .isEqualTo(employee.getId());
        Assertions.assertThat(employee1.getFirstname())
                .as("Validate First Name")
                .isEqualTo(employee.getFirstname());
        Assertions.assertThat(employee1.getLastname())
                .as("Validate Last Name")
                .isEqualTo(employee.getLastname());

    }
}

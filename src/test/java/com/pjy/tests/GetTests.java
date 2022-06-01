package com.pjy.tests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static com.pjy.builder.RequestBuilder.*;

public class GetTests {

    @Test
    public void getEmloyees(){
        Response response = buildGetPayload()
                             .get("/employees");
        Assertions.assertThat(response.getStatusCode())
                .as("Validation of Status Code")
                .isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getList("$").size())
                .as("Validation the no of Employees")
                .isPositive()
                .isBetween(1,50);
    }

    @Test
    public void getEmployee(){
        Response response = buildGetPayload()
                .pathParams("id", 1)
                .get("/employees/{id}");
        response.prettyPrint();
        Assertions.assertThat(response.jsonPath().getString("first_name"))
                .as("Validation of First Name")
                .isEqualTo("Renganathan");

    }


}

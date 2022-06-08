package com.pjy.tests;

import base.BaseTest;
import com.pjy.annotations.FrameworkAnnotation;
import com.pjy.reports.ExtentLogger;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import static com.pjy.builder.RequestBuilder.*;

public class GetTests extends BaseTest {

    @Test
    @FrameworkAnnotation(autors = {"Sathish","Siva"},category = {"Smoke","Regression"})
    public void getEmloyees(){
        Response response = buildGetPayload()
                             .get("/employees");
        Assertions.assertThat(response.getStatusCode())
                .as("Validation of Status Code")
                .isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getList("$").size())
                .as("Validation the no of Employees")
                .isPositive()
                .isBetween(1,150);
        ExtentLogger.passWithJSON(response.asPrettyString());
    }

    @Test
    @FrameworkAnnotation(autors = {"Krishna","Siva"},category = {"sanity","Regression"})
    public void getEmployee(){
        Response response = buildGetPayload()
                .pathParams("id", 1)
                .get("/employees/{id}");
        response.prettyPrint();
        Assertions.assertThat(response.jsonPath().getString("first_name"))
                .as("Validation of First Name")
                .isEqualTo("Renganathan");
        ExtentLogger.passWithJSON(response.asPrettyString());

    }


}

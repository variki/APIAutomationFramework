package com.pjy.tests;

import base.BaseTest;
import com.pjy.annotations.FrameworkAnnotation;
import com.pjy.pojo.Employee;
import com.pjy.reports.ExtentLogger;
import com.pjy.reports.ExtentReportUtils;
import com.pjy.utils.FileUtils;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.pjy.builder.RequestBuilder.*;
import static com.pjy.utils.RandomValuesUtils.*;

public class PostTests extends BaseTest {

    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[3][1];
        Map<String,Object> map = new HashMap<>();
        map.put("Id",getId());
        map.put("fname",getFirstName());
        map.put("lname",getLastName());

        Map<String,Object> map1 = new HashMap<>();
        map1.put("Id",getId());
        map1.put("fname",getFirstName());
        map1.put("lname",getLastName());

        Map<String,Object> map2= new HashMap<>();
        map2.put("Id",getId());
        map2.put("fname",getFirstName());
        map2.put("lname",getLastName());

        data[0][0] = map;
        data[1][0] = map1;
        data[2][0]=map2;

        return data;
    }

    @Test(dataProvider = "getdata")
    @FrameworkAnnotation(autors = {"Sathish","Krishna"},category = {"Smoke","sanity"})
    public void createEmployee(Map<String,Object> data){
        Employee employee = Employee.builder()
                .setId((Integer) data.get("Id"))
                .setFirstname((String) data.get("fname"))
                .setLastname((String) data.get("lname"))
                .build();

        Response response = buildPostPayload()
                .body(employee)
                .post("/employees");
        response.prettyPrint();
        ExtentLogger.pass(response.asPrettyString());
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

    @Test
    @FrameworkAnnotation(autors = {"Krishna","Lavanya"},category = {"Regression"})
    public void createEmployeeUsingFile(){
        String createEmloyee = FileUtils.readRequestJSONandConvertString("createEmployee")
                .replace("${idNumber}",String.valueOf(getId()))
                .replace("fname",getFirstName())
                .replace("lname",getLastName());

        RequestSpecification requestSpecification = buildPostPayload()
                .body(createEmloyee);
        ExtentLogger.logRequest(requestSpecification);
        Response response = requestSpecification.post("/employees");
        response.prettyPrint();

        Assertions.assertThat(response.getStatusCode())
                .as("Validating Status Code")
                .isEqualTo(201);
        FileUtils.storeResponseJSON("createEmployeeResponse",response);
        ExtentLogger.passWithJSON(response.asPrettyString());

      //  response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir"))+"/src/test/resources/schema/schema.json"));




    }
}

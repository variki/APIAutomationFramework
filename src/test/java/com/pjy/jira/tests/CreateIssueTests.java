package com.pjy.jira.tests;

import com.pjy.annotations.FrameworkAnnotation;
import com.pjy.builder.RequestBuilder;
import com.pjy.reports.ExtentLogger;
import com.pjy.utils.FileUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateIssueTests {

    @Test
    @FrameworkAnnotation(autors = {"sathish"},category = {"regression"})
    public void createIssueTest(){
        String body = FileUtils.readRequestJSONandConvertString("createIssue")
                .replace("KEY","DEMO")
                .replace("SUMMARY","Create Issue using REST API")
                .replace("DESCRIPTION","REST ye merry gentlemen.");

        Response response = RequestBuilder.buildPostPayload()
                .header("Authorization", "Basic c2F0aGlzaGFwOmppcmFAMTAy")
               // .auth()
                //.basic("kumarsathish542","jira@102")
                .body(body)
                .post("/rest/api/2/issue/");
        ExtentLogger.inforWithJSON(response.asPrettyString());
        System.out.println(response.prettyPrint());

    }
}

package com.pjy.builder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    private RequestBuilder(){}

    public static RequestSpecification buildGetPayload(){
        return given().
                baseUri("http://localhost:3000")
                .log()
                .all();
    }

    public static RequestSpecification buildPostPayload(){
        return buildGetPayload().contentType(ContentType.JSON);
    }


}

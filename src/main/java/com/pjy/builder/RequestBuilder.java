package com.pjy.builder;

import com.pjy.utils.PropertiesUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public final class RequestBuilder {

    private RequestBuilder(){}

    public static RequestSpecification buildGetPayload(){
        return given().
                baseUri(PropertiesUtils.getValue("baseURL"))
                .log()
                .all();
    }

    public static RequestSpecification buildPostPayload(){
        return buildGetPayload().contentType(ContentType.JSON);
    }


}

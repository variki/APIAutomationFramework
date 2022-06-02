package com.pjy.utils;

import com.pjy.constants.FrameworkConstants;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileUtils {

    private FileUtils(){}

    @SneakyThrows
    public static String readRequestJSONandConvertString(String filename){
        return new String(Files.readAllBytes(Paths.get(FrameworkConstants.getRequestJsonFolderPath()+filename+".json")));
    }

    @SneakyThrows
    public static void storeResponseJSON(String filename, Response response){
        Files.write(Paths.get(FrameworkConstants.getResponseJsonFolderPath()+filename+".json"),response.asByteArray());
    }

}

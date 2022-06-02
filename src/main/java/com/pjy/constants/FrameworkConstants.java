package com.pjy.constants;

import lombok.Getter;

public class FrameworkConstants {

    private static @Getter final String requestJsonFolderPath = System.getProperty("user.dir")+"/src/test/resources/payload/";
    private static @Getter final String responseJsonFolderPath= System.getProperty("user.dir")+"/output/";
    private static @Getter final String frameworkConfigFilePath = System.getProperty("user.dir")+"/src/test/resources/Config/config.properties";
}

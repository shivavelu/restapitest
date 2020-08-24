package com.reflektion.framework.utils;

/**
 * Author: Sivasubramaniam
 * Version: 1.0
 * Class Description: This class hold all final value here.
 */
public class Constant {

    private Constant() {
        throw new IllegalStateException("Constant Class");
    }
    public static final int STATUSCODE_200 = 200;
    public static final int STATUSCODE_201 = 201;
    public static final int STATUSCODE_400 = 400;
    public static final int STATUSCODE_404 = 404;
    public static final String STATUSLINE_200="HTTP/1.1 200 OK";
    public static final String CONTENTTYPEXML = "application/xml";
    public static final String CONTENTYPEJSON = "application/json";
    public static final String PROPRETYFILEPATH = "src/main/resources/sample.properties";

}

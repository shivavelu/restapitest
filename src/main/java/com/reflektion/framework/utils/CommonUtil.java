package com.reflektion.framework.utils;

import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author: Sivasubramaniam
 * Version: 1.0
 * Class Description: This class holds all common util functions, may be static method implemenation
 */
public class CommonUtil {

    private CommonUtil() {
        throw new IllegalStateException("CommonUtil class");
    }

    public static String returnProperties(String filePath, String keyName) throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream(filePath);
        prop.load(input);
        return prop.getProperty(keyName);
    }

    public static String readJsonasString(String filePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            return obj.toString();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return  null;
    }
}

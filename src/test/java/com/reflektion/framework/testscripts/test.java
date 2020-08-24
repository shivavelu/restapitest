package com.reflektion.framework.testscripts;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class test {


    public void readJosn() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./src/test/resources/payload/updaterecord.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

           //JSONArray employeeList = (JSONArray) obj;


            System.out.println(obj.toString());

        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        new test().readJosn();
    }

}


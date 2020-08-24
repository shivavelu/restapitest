package com.reflektion.framework.testscripts;

import com.reflektion.framework.utils.CommonUtil;
import com.reflektion.framework.utils.Constant;
import com.reflektion.framework.wrapper.RestAssuredCore;
import com.reflektion.framework.wrapper.RestResponse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.reflektion.framework.utils.Constant.STATUSCODE_201;
import static com.reflektion.framework.wrapper.RestAssuredCore.closeLogger;
import static com.reflektion.framework.wrapper.RestAssuredCore.initializeLogger;
import static com.reflektion.framework.utils.CommonUtil.readJsonasString;

public class WriteServices {
    private RestAssuredCore restAssuredCore;

    @BeforeMethod
    public void init() throws IOException {
        initializeLogger();
        restAssuredCore = new RestAssuredCore((CommonUtil.returnProperties(Constant.PROPRETYFILEPATH, "serviceBaseURI"))
                , CommonUtil.returnProperties(Constant.PROPRETYFILEPATH, "serviceBasePath"));
    }

    @Test
    public void createRecord() {
        RestResponse response = restAssuredCore.setURLEncodingStatus(false).setHeader("Content-Type","application/json").invokeRestCallPostBodyString(readJsonasString("./src/test/resources/payload/createrecord.json"));
        Assert.assertEquals(response.getStatusCode(), STATUSCODE_201);
        Assert.assertEquals((response.getJpathvaluetext("title")), "foo");
        response.verifySchema("createdres.json");
    }



    @AfterMethod
    public void tearDown() {
        restAssuredCore.resetRestConfig("all");
        closeLogger();
    }

}

package com.reflektion.framework.testscripts;

import com.reflektion.framework.wrapper.RestAssuredCore;
import com.reflektion.framework.wrapper.RestResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.reflektion.framework.utils.CommonUtil;
import com.reflektion.framework.utils.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

import static com.reflektion.framework.utils.Constant.STATUSCODE_200;
import static com.reflektion.framework.utils.Constant.STATUSCODE_404;
import static com.reflektion.framework.wrapper.RestAssuredCore.closeLogger;
import static com.reflektion.framework.wrapper.RestAssuredCore.initializeLogger;


public class ReadServices {

    private RestAssuredCore restAssuredCore;

    @BeforeMethod
    public void init() throws IOException {
        initializeLogger();
        restAssuredCore = new RestAssuredCore((CommonUtil.returnProperties(Constant.PROPRETYFILEPATH, "serviceBaseURI"))
                , CommonUtil.returnProperties(Constant.PROPRETYFILEPATH, "serviceBasePath"));
    }

    @Test
    public void getAllPosts() {
        RestResponse response = restAssuredCore.setURLEncodingStatus(false).invokeRestCallNoResoruce("GET");
        Assert.assertEquals(response.getStatusCode(), STATUSCODE_200);
        Assert.assertEquals(response.verifyarrayCount().size(), 100);
        response.verifySchema("posts.json");
    }

    @Test
    public void getSpecificPost() {
        RestResponse response = restAssuredCore.setURLEncodingStatus(false).invokeRestCall("GET", "1");
        Assert.assertEquals(response.getStatusCode(), STATUSCODE_200);
        Assert.assertEquals((response.getJpathvalue("id")), 1);
        response.verifySchema("postspecific.json");
    }

    @Test
    public void invalvidPost() {
        RestResponse response = restAssuredCore.setURLEncodingStatus(false).invokeRestCall("GET", "invalidposts");
        Assert.assertEquals(response.getStatusCode(), STATUSCODE_404);
    }

    @AfterMethod
    public void tearDown() {
        restAssuredCore.resetRestConfig("all");
        closeLogger();
    }

}



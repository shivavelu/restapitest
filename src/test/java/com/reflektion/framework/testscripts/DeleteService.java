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

import static com.reflektion.framework.utils.CommonUtil.readJsonasString;
import static com.reflektion.framework.utils.Constant.STATUSCODE_200;
import static com.reflektion.framework.wrapper.RestAssuredCore.closeLogger;
import static com.reflektion.framework.wrapper.RestAssuredCore.initializeLogger;

public class DeleteService {
    private RestAssuredCore restAssuredCore;

    @BeforeMethod
    public void init() throws IOException {
        initializeLogger();
        restAssuredCore = new RestAssuredCore((CommonUtil.returnProperties(Constant.PROPRETYFILEPATH, "serviceBaseURI"))
                , CommonUtil.returnProperties(Constant.PROPRETYFILEPATH, "serviceBasePath"));
    }

    @Test
    public void updateRecord() {
        RestResponse response = restAssuredCore.setURLEncodingStatus(false).invokeRestCall("DELETE", "1");
        Assert.assertEquals(response.getStatusCode(), STATUSCODE_200);

    }


    @AfterMethod
    public void tearDown() {
        restAssuredCore.resetRestConfig("all");
        closeLogger();
    }

}

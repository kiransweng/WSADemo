package com.dxc.restdemo.services;

import com.dxc.restdemo.utils.GlobalConstants;
import com.dxc.restdemo.utils.RestWrapper;
import io.restassured.response.Response;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoServices extends ServiceBase {

    @Value("${demoservice.host}")
    private String host;

    @Autowired RestWrapper restWrapper;

    public Response getWeatherResponse() throws Throwable{
        params.put("ip","20.20.20.20");
        return restWrapper.getAsResponse(host,GlobalConstants.GEO_INFO,params,headers);
    }
}

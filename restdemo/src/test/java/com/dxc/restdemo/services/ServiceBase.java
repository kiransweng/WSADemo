package com.dxc.restdemo.services;

import java.util.HashMap;
import java.util.Map;

public class ServiceBase {

    protected Map<String, String> params  = new HashMap<>();
    protected Map<String, Object> headers = new HashMap<>();
    protected Map<String, String> formParams = new HashMap<>();
    protected Map<String, String> authKeys = new HashMap<>();
    protected String pathParams;

    public void resetHeaders(){
        headers.clear();
    }
    public void resetParams(){
        params.clear();
    }
    public void resetFormParams(){
        formParams.clear();
    }
    public void resetAuthKeys(){
        authKeys.clear();
    }
}

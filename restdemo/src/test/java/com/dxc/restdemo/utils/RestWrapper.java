package com.dxc.restdemo.utils;

import static io.restassured.RestAssured.given;

import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vkuma26 on 8/26/19.
 */
@Component
public class RestWrapper {

  private static final Logger logger = LogManager.getLogger(RestWrapper.class);

  @Autowired
  private ScenarioContext scenarioContext;

  public Response getAsResponse(String host, String endpointUrl, Map<String, String> params, Map<String, Object> headers){

    Response resp = given().
        baseUri(host).
        basePath(endpointUrl).
        config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
        params(params).
        headers(headers).
        urlEncodingEnabled(false).
        log().uri().
        get().
        then().
        log().status().
        extract().
        response();

    scenarioContext.setResponse(resp);
    return resp;
  }

	public Response getAsResponseWithPathParams(String host, String endpointUrl, Map<String, String> params, Map<String, Object> headers ){

		Response resp = given().
				baseUri(host).
				basePath(endpointUrl).
				config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
				pathParams(params).
				headers(headers).
				urlEncodingEnabled(false).
				log().uri().
				get().
				then().
				log().status().
				extract().
				response();

		scenarioContext.setResponse(resp);
		return resp;
	}
  
  public Response postAsResponse(String host, String endpointUrl, Map<String, Object> headers, String jsonBody ){

	  Response resp = given().
	        baseUri(host).
            config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
	        headers(headers).
	        body(jsonBody).
	        urlEncodingEnabled(false).
	        log().uri().
	        post(endpointUrl).
	        then().
          log().status().
	        extract().
	        response();
	    scenarioContext.setResponse(resp);
	    return resp;
	  }

  public Response postWithFormParams(String host, String endpointUrl, Map<String, String> params, Map<String, Object> headers ){

	  Response resp = given().
	        baseUri(host).
	        basePath(endpointUrl).
            config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
	        queryParams(params).
	        headers(headers).
	        urlEncodingEnabled(true).
	        log().uri().
	        post().
	        then().
          log().status().
	        extract().
	        response();
    scenarioContext.setResponse(resp);
    return resp;
	  }

	public Response postWithPathParams(String host, String endpointUrl, Map<String, String> pathParams, Map<String, Object> headers, String jsonBody ){

		Response resp = given().
				baseUri(host).
				basePath(endpointUrl).
				config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
				pathParams(pathParams).
				headers(headers).
				body(jsonBody).
				urlEncodingEnabled(true).
				log().uri().
				post().
				then().
				log().status().
				extract().
				response();
		scenarioContext.setResponse(resp);
		return resp;
	}

  public Response postAuthFormParams(String host, String endpointUrl, Map<String, String> params, Map<String, Object> headers, Map<String, String> auth){

    Response resp = given().
        baseUri(host).
        basePath(endpointUrl).
        config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
        queryParams(params).
        headers(headers).
        auth().preemptive().basic(auth.get("username"), auth.get("password")).
        urlEncodingEnabled(true).
        log().uri().
        post().
        then().
        log().status().
        extract().
        response();
    scenarioContext.setResponse(resp);
    return resp;
  }

  public Response getResponseWithPathAndQueryParams(String host, String endpointUrl, String pathParam, Map<String, String> queryparams ){

     Response resp = given().
              baseUri(host).
              basePath(endpointUrl).
              config(RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())).
              params(queryparams).
              urlEncodingEnabled(false).
              log().uri().
              get("/{pathParam}",pathParam).
              then().
              log().status().
              extract().
              response();
      scenarioContext.setResponse(resp);
      return resp;
    }

}

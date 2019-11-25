package com.dxc.restdemo.stepdefinitions;

import com.dxc.restdemo.RestServiceDemoApplicationTests;
import com.dxc.restdemo.services.DemoServices;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vkuma26 on 8/26/19.
 */
public class Hooks extends RestServiceDemoApplicationTests {

  @Autowired
  DemoServices demoService;


  @Before
  public void setUp(){

  }

  @After
  public void tearDown(){
    demoService.resetHeaders();
    demoService.resetParams();
    demoService.resetFormParams();
    demoService.resetAuthKeys();
  }

}

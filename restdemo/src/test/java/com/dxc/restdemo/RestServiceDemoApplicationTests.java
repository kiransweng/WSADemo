package com.dxc.restdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {ApplicationConfig.class})
public class RestServiceDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}

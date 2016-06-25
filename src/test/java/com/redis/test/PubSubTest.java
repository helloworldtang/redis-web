/**
 * 2014-7-2 
 * PubSybTest.java 
 * author:Edwin Chen
 */
package com.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redis.service.impl.PubServiceImpl;

/**
 * @author new
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/config/spring-context.xml",
		"classpath:WEB-INF/config/redis-context.xml"})
public class PubSubTest {
	@Autowired
	private PubServiceImpl pubservice ;
	
	@Test
	public void PubTest() {
		String message = "chenhaoran2";
		pubservice.Publisher(message);
	}
}

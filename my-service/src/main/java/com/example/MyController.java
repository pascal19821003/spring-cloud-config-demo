package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Turanski
 **/
@RestController
@EnableConfigurationProperties(MyProperties.class)
// Uncomment @RefreshScope to enable refreshes to this class
@RefreshScope
public class MyController {

	private static Logger logger = LoggerFactory.getLogger(MyController.class);

	@Autowired
	MyProperties properties;

	@Value("${info.foo}")
	String value;

	@Value("${my.password}")
	String password;

	@Value("${name}")
	String name;

	@RequestMapping("/")
	@ResponseBody
	public Response respond() {
		logger.debug("@ConfigurationProperties: {} @Value: {}", properties, value);
		//Generally not a great idea...
		logger.debug("password: {}", password);
		logger.debug("name: {}", name);
		return new Response(properties, value);
	}
}
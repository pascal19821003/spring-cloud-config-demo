package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author David Turanski
 **/
@ConfigurationProperties(prefix = MyProperties.prefix)
public class MyProperties {
	public static final String prefix = "info";
	private String foo;
	private String bar;

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	public String getPrefix() {
		return MyProperties.prefix;
	}

	public String toString() {
		//	{"value":"the next new value",
		// "configProps":{"foo":"the next new value","bar":"boot","prefix":"info"}}
		//

//		info: foo: the next new value
		return String.format("{\"prefix\": \"%s\", \"foo\": \"%s\", \"bar\": \"%s\"}",
				prefix, foo, bar);
	}
}

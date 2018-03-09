package com.autowiredExample;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyAwareExample implements ApplicationContextAware, BeanNameAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		System.out.println("set Application Context");
		System.out.println("set Application Context"
				+ Arrays.toString(applicationContext.getBeanDefinitionNames()));

	}

	@Override
	public void setBeanName(String string) {

		System.out.println("bnean name");
		System.out.println("bean name " + string);
	}

}

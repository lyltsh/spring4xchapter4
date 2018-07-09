package com.smart.beanfactory;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{

	//在实例化bean前调用
	public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");			
		}		
		return null;
	}

	//在实例化bean后调用
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if("car".equals(beanName)){
		System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
		}
		return true;
	}

	//在设置某属性时调用
	public PropertyValues postProcessPropertyValues(
			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		if("car".equals(beanName)){
		   System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
		}
		return pvs;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}

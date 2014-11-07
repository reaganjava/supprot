package com.reagan.support.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.reagan.util.init.IBeanInitialization;

@Component
public class SystemInitProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String arg)
			throws BeansException {
		System.out.println(bean.toString() + "=========" + (bean instanceof IBeanInitialization));
		if(bean instanceof IBeanInitialization) {
			IBeanInitialization initialization = (IBeanInitialization)bean;
			try {
				initialization.initializer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String arg)
			throws BeansException {
		return bean;
	}

}

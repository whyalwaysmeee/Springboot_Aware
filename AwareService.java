package com.aware;

import org.apache.commons.io.IOUtils;
import java.io.IOException;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware { //实现BNA和RLA接口
	private String beanName;
	private ResourceLoader loader;
	
	//@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {    //重写setResourceloader方法来实现RLA接口
		this.loader = resourceLoader;
	}
	
	//@Override
	public void setBeanName(String name) {                //重写setBeanName方法来实现BNA接口
		this.beanName = name;
	}
	
	public void outputResult() {
		System.out.println("Bean的名称为：" + beanName);
		Resource resource = loader.getResource("classpath:com/aware/test.txt");
		try {
			System.out.println("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}

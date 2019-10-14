package spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import spring.UserService;

public class TestBeanFactory {

	public static void main(String[] args){
		/**
		 * BeanFactory获取IOC容器的三种方式：
		 * 		1. 【推荐使用】ClassPathResource 从类路径（class字节码所在路径）下加载xml文件
				2. FileSystemResource 从文件系统路径下加载xml文件
		 */
		/**
		 * 1. 【推荐使用】ClassPathResource 从类路径（class字节码所在路径）下加载xml文件，相对于src根路径
		 */
		//① 加载单个配置文件
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("config/applicationContext_2.xml"));
		
		/**
		 * 2. FileSystemResource 从文件系统路径下加载xml文件，相对于项目根路径
		 */
		//① 相对路径
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/applicationContext.xml"));
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("applicationContext_3.xml"));
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("config/applicationContext_4.xml"));
		
		//② 绝对路径
		//BeanFactory factory = new FileSystemXmlApplicationContext("E:\\Workspaces\\Eclipse_JAVA08\\day02_spring01_IOC容器\\config\\applicationContext_4.xml");
		
		System.out.println("-----------------获取IOC容器完成---------------------------");
		
		//2.获取工厂中的service对象了
		UserService userService = (UserService)factory.getBean("userService");
		
		//3.调用方法
		userService.findUsers();
	}

}

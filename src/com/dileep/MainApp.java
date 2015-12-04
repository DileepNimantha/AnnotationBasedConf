package com.dileep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		Student student1 = (Student) context.getBean("student");

		System.out.println("Name : " + student1.getName());
		System.out.println("Age : " + student1.getAge());
	}
}

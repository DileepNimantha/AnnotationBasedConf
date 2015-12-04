package com.dileep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	static ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	public static void main(String[] args) {
		demoRequiredAnnotation();
		demoAutowiredAnnotation();
		demoQualifierAnnotation();
		demoJSR250Annotation();
	}

	public static void demoRequiredAnnotation() {
		System.out.println("\nDemo Required annotation");
		Student student1 = (Student) context.getBean("student");

		System.out.println("Name : " + student1.getName());
		System.out.println("Age : " + student1.getAge());
	}

	public static void demoAutowiredAnnotation() {
		System.out.println("\nDemo Autowired annotation");
		TextEditor te = (TextEditor) context.getBean("textEditor");

		te.spellCheck();
	}

	private static void demoQualifierAnnotation() {
		System.out.println("\nDemo Qualifier annotation");
		Profile profile = (Profile) context.getBean("profile");

		profile.printAge();
		profile.printName();
	}

	private static void demoJSR250Annotation() {
		System.out.println("\nDemo JSR-250 annotation");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		((AbstractApplicationContext) context).registerShutdownHook();
	}

}

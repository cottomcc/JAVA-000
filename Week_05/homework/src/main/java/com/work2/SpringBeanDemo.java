package com.work2;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.UnsupportedEncodingException;


@PropertySource("student-annotation.properties")
public class SpringBeanDemo {

    @Bean
    public Student getStudent(@Value("${student.id}") int id, @Value("${student.name}")String name){
        return new Student(id, name);
    }


    public static Student loadFromAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringBeanDemo.class);
        applicationContext.refresh();
        Student student = applicationContext.getBean("getStudent", Student.class);
        return student;
    }
    public static Student loadFromXML() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("student.xml");
        return beanFactory.getBean("student", Student.class);
    }
    public static Student loadFromProperties() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new EncodedResource(new ClassPathResource("student.properties"), "UTF-8"));
        return beanFactory.getBean("student", Student.class);
    }
}

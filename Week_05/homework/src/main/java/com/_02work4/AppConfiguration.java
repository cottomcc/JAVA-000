package com._02work4;

import com._02work4.pojo.Klass;
import com._02work4.pojo.Student;
import com._02work4.pojo.School;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(AppConfiguration.class)
@ConditionalOnProperty(prefix = "com._02work4.pojo", name = "enabled", havingValue = "true", matchIfMissing = true)
public class AppConfiguration {

    @Bean(name = "student100")
    public Student student100() {
        return new Student(100, "cc");
    }


    @Bean
    public Klass getKlass() {
        Klass klass = new Klass();
        List<Student> list = new ArrayList<>();
        list.add(student100());
        klass.setStudents(list);
        return klass;
    }

    @Bean
    public School getSchool() {
        School school = new School();
        school.setClass1(getKlass());
        school.setStudent100(student100());
        return school;
    }

}

package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {}

record Address(String firstLina, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    String name() {
        return "Estael";
    }

    @Bean
    int age() {
        return 15;
    }

    @Bean
    Person person() {
        return new Person("Meireles", 24, new Address("Pará", "Nova Timboteua"));
    }

    @Bean
    Person person2() {
        return new Person(name(), age(), address());
    }

    @Bean
    Person person3(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    Address address() {
        return new Address("Pará", "Nova Timboteua");
    }

    @Bean
    Address address2() {
        return new Address("Pará", "Nova Timboteua");
    }

}

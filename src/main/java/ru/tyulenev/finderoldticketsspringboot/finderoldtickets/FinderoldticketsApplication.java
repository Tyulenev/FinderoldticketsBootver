package ru.tyulenev.finderoldticketsspringboot.finderoldtickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class FinderoldticketsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FinderoldticketsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FinderoldticketsApplication.class);
    }

}

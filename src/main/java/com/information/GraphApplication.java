package com.information;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.information.*"})
public class GraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

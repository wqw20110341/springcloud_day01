package com.toec;

import com.toec.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        TestController controller = new TestController();
        TestController bean = context.getBean(TestController.class);
        System.out.println("bean================>"+bean);
    }

}

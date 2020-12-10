package org.example;

import org.example.config.Config;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Communication communication = context.getBean("communication", Communication.class);
        List<User> allUser = communication.getAllUsers();
        System.out.println(allUser);
    }
}

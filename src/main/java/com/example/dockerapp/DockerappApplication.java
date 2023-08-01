package com.example.dockerapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DockerappApplication {
 
@RequestMapping("/")
public String home() {
return "Hello This Is Charan!";
}
 
public static void main(String[] args) {
SpringApplication.run(DockerappApplication.class, args);
}
 
}

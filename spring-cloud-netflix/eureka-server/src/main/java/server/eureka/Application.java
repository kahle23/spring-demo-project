package server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Startup class.
 * @author Kahle
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {

    /**
     * Program entry.
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}

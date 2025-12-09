package server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Startup class.
 * @author Kahle
 */
@EnableConfigServer
@EnableDiscoveryClient
@EnableAutoConfiguration
public class Application {

    /**
     * Program entry.
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}

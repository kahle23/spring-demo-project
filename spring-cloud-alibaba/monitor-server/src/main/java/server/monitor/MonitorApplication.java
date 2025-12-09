package server.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The startup class.
 * @author Kahle
 */
@Slf4j
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class MonitorApplication {

    /**
     * The program entry.
     * @param args The entry arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
        log.info("The server \"monitor-server\" start success! ");
    }

}

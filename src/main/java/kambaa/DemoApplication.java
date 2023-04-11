package kambaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Demo Spring Application.
 *
 * @author Kambaa
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 **/
@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
//excluded in order to avoid autoconfiguring an extra Hazelcast instance
@EnableScheduling
// needed just for the sake of SecondLevelCacheVisualizer
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

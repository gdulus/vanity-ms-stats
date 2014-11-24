package ms.vanity.stats

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@EnableAutoConfiguration
class Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }
}

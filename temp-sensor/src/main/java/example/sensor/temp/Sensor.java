package example.sensor.temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sensor implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Sensor.class);

    @Override
    public void run(String... args) throws Exception {
        
    }
}

package example.sensor.temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Mimics a temperature sensor that records temperature data every 1 second.
 */
@Component
public class Sensor implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Sensor.class);

    @Override
    public void run(String... args) throws Exception {
        final String sensorId = "temp-" + UUID.randomUUID().toString().replace("-", "");

        LOG.info("Starting Sensor: {}", sensorId);

        Flux.interval(Duration.ofSeconds(1))
                .map(tick -> ThreadLocalRandom.current().nextDouble(70.0, 72.0))
                .subscribe(temp -> {
                    LOG.info("Temp: " + temp);
                });

        Thread.currentThread().join();
    }
}

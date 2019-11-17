package example.sensor.temp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
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

    @Autowired
    @Qualifier("mqttClientId")
    private String mqttClientId;

    @Autowired
    private IntegrationFlow mqttOutboundFlow;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Starting Sensor: {}", mqttClientId);

        Flux.interval(Duration.ofSeconds(1))
                .map(tick -> ThreadLocalRandom.current().nextDouble(70.0, 72.0))
                .subscribe(temp -> {
                    LOG.info("Temp: " + temp);
                    mqttOutboundFlow.getInputChannel().send(new Message<Double>() {
                        @Override
                        public Double getPayload() {
                            return temp;
                        }

                        @Override
                        public MessageHeaders getHeaders() {
                            return null;
                        }
                    });
                });

        Thread.currentThread().join();
    }
}

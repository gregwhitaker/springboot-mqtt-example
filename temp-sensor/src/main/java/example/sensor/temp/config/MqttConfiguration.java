package example.sensor.temp.config;

import example.sensor.temp.config.settings.MqttSettings;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;

import java.util.UUID;

@Configuration
@EnableConfigurationProperties({
        MqttSettings.class
})
public class MqttConfiguration {

    @Bean
    public String mqttClientId() {
        return "temp-" + UUID.randomUUID().toString().replace("-", "");
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory(MqttSettings settings) {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] { String.format("tcp://%s:%s", settings.getHostname(), settings.getPort()) });

        if (settings.getUsername() != null && !settings.getUsername().isEmpty()) {
            options.setUserName(settings.getUsername());
        }

        if (settings.getPassword() != null && !settings.getPassword().isEmpty()) {
            options.setPassword(settings.getPassword().toCharArray());
        }

        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(options);

        return factory;
    }

    @Bean
    public IntegrationFlow mqttOutboundFlow(@Qualifier("mqttClientId") String mqttClientId,
                                            MqttPahoClientFactory mqttClientFactory) {
        return f -> f.handle(new MqttPahoMessageHandler(mqttClientId, mqttClientFactory));
    }
}

package example.sensor.temp.config;

import example.sensor.temp.config.settings.MqttSettings;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableConfigurationProperties({
        MqttSettings.class
})
public class MqttConfiguration {

    @Bean
    public MqttPahoClientFactory mqttClientFactory(MqttSettings settings) {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] { String.format("tcp://%s:%s", settings.getHostname(), settings.getPort()) });
        options.setUserName(settings.getUsername());
        options.setPassword(settings.getPassword().toCharArray());

        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(options);

        return factory;
    }

//    @Bean
//    @ServiceActivator(inputChannel = "tempOutboundChannel")
//    public MessageHandler mqttOutbound() {
//        MqttPahoMessageHandler messageHandler =
//                new MqttPahoMessageHandler("testClient", mqttClientFactory());
//        messageHandler.setAsync(true);
//        messageHandler.setDefaultTopic("testTopic");
//
//        return messageHandler;
//    }

    @Bean
    public MessageChannel tempOutboundChannel() {
        return new DirectChannel();
    }
}

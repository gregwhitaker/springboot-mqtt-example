package example.sensor.temp.gateway;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "tempOutboundChannel")
public interface TempGateway {

    void sendTemp(TempMessage tempMessage);
}

package example.service.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.model.TempMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TempMessageHandler implements MessageHandler {
    private static final Logger LOG = LoggerFactory.getLogger(TempMessageHandler.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        try {
            TempMessage tempMessage = mapper.readerFor(TempMessage.class).readValue(message.getPayload().toString());
            LOG.info("Received Temp: " + tempMessage.getTemp());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

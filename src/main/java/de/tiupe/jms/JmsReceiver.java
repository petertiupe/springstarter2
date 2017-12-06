package de.tiupe.jms;


import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class JmsReceiver implements MessageListener{

    @Override
    public void onMessage(Message message) {
        System.out.println("Received: " + message);
    }

}

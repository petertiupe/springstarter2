package de.tiupe.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class JmsSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Scheduled(initialDelay=1000, fixedDelay = 1000)
    public void sendText(){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session)
                    throws JMSException {
                return session.createTextMessage("Hallo!");
            }
        });
    }


}

package de.tiupe.config;


import de.tiupe.jms.JmsReceiver;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import java.net.URI;

@Configuration
@ComponentScan("de.tiupe.jms")
public class JMSConfig {


    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(new ActiveMQQueue("jms.queue"));
        jmsTemplate.setConnectionFactory(connectionFactory());
        return jmsTemplate;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.addConnector(new URI("tcp://localhost:61616"));
        brokerService.setPersistent(false);
        brokerService.start();
        return brokerService;
    }

    @Bean
    public DefaultMessageListenerContainer messageListenerContainer(JmsReceiver jmsReceiver) {
        DefaultMessageListenerContainer messageListenerContainer =
                new DefaultMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory());
        messageListenerContainer.setDestinationName("jms.queue");
        messageListenerContainer.setMessageListener(jmsReceiver);
        return messageListenerContainer;
    }
}

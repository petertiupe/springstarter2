package de.tiupe.config;


import de.tiupe.business.UserMonitor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
public class JMXConfig {
    @Bean
    public UserMonitor userMonitor(){
        return new UserMonitor();
    }
}

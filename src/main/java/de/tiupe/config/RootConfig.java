package de.tiupe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// Die SecurityConfig muss in der Root Config liegen, daher wird sie hier importiert.

@Configuration
@ComponentScan(basePackages={"de.tiupe.business"})
@Import({SecurityConfig.class, DatabaseConfig.class, CacheConfig.class, JMXConfig.class})
public class RootConfig {
}

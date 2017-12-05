package de.tiupe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"de.tiupe.business"})
public class RootConfig {
}

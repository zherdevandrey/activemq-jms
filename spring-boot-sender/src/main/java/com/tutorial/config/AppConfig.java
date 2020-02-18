package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "tutorial.com.*")
@Import(MessageConfiguration.class)
public class AppConfig {
}

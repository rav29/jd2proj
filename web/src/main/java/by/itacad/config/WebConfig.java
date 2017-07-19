package by.itacad.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Radion on 15.07.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.itacad.controller"})
@Import(value = {ThymeleafConfig.class, Config.class})
public class WebConfig {
}

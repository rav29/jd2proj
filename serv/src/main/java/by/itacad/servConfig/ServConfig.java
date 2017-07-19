package by.itacad.servConfig;

import by.itacad.config.Config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Radion on 15.07.2017.
 */
@Configuration
@Import(Config.class)
@ComponentScan("by.itacad.service")
public class ServConfig {
}

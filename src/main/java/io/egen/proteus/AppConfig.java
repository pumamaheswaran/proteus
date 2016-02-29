package io.egen.proteus;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * A spring specific class.
 * @author Pravin Umamaheswaran
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan
public class AppConfig extends WebMvcConfigurerAdapter {

}

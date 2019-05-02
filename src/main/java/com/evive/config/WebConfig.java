package com.evive.config;

import com.evive.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    log.info ( "Comes here" );
    // for Initializing home view to localhost:8080/
    registry.addViewController ( "/" ).setViewName ( ViewNames.HOME);
  }
}

package com.sigma.springsecurity.config.core;

/**
 * Created by Tahir on 4/25/2015.
 */

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.sigma.springsecurity.config.AppConfig;

public class SpringMvcInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { AppConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
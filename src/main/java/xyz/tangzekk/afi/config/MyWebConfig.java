package xyz.tangzekk.afi.config;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.format.*;
import org.springframework.http.converter.*;
import org.springframework.validation.*;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import xyz.tangzekk.afi.inteceptor.MyInteceptor;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 11:13
 **/
@Configuration
public class MyWebConfig implements WebMvcConfigurer {


  @Autowired
  MyInteceptor myInteceptor;
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(myInteceptor);
  }


}
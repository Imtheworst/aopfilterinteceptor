package xyz.tangzekk.afi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 11:06
 **/
@Slf4j
@Component
public class MyFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    log.error("[ MyFilter ] { doFilter }");
//    log.info(servletRequest.get);


    filterChain.doFilter(servletRequest, servletResponse);

  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.error("[ MyFilter ] { init }");

  }

  @Override
  public void destroy() {
    log.error("[ MyFilter ] { destroy }");

  }
}
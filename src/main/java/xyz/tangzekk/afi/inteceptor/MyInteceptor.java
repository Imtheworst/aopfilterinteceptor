package xyz.tangzekk.afi.inteceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.method.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.*;
import xyz.tangzekk.afi.aop.Inc;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 11:09
 **/
@Slf4j
@Component
public class MyInteceptor extends HandlerInterceptorAdapter {

  public MyInteceptor() {
    super();
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.error("[ MyInteceptor ] { preHandle }");
    getIncAnnotationValue(handler);

    return super.preHandle(request, response, handler);
  }

  private void getIncAnnotationValue(Object handler) {
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      Method method = handlerMethod.getMethod();
      TypeVariable<Method>[] typeParameters = method.getTypeParameters();

      Parameter[] parameters = method.getParameters();
      Arrays.stream(typeParameters).forEach(System.out::println);
      Arrays.stream(parameters).forEach(System.out::println);
//      typeParameters[

      if (method.isAnnotationPresent(Inc.class)) {
        Inc declaredAnnotation = method.getDeclaredAnnotation(Inc.class);
//        method.anno
//        Optional<String> incValue = annotation.value();

        if (!StringUtils.isEmpty(declaredAnnotation.value())) {
          log.info("[ MyInteceptor ] => 取得 @Inc 注解的 value" + declaredAnnotation.value());

//          log.info("[ MyInteceptor ] => 取得 @Inc 注解的 value" ,declaredAnnotation.value().toString());  //  不生效 原因不明

        }
      }

    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.error("[ MyInteceptor ] { postHandle }");

    super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    log.error("[ MyInteceptor ] { afterCompletion }");

    super.afterCompletion(request, response, handler, ex);
  }

  @Override
  public void afterConcurrentHandlingStarted(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {
    log.error("[ MyInteceptor ] { afterConcurrentHandlingStarted }");

    super.afterConcurrentHandlingStarted(request, response, handler);
  }
}
package xyz.tangzekk.afi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

/**
 * @program: aopfilterinteceptor
 * @description:
 * @author: tangzekai
 * @create: 2019-04-16 10:49
 **/
@Aspect
@Component
@Slf4j
public class WebAop {
//   saonima 这个不能写错
//  @Pointcut("execution(* xyz.tangzekk.afi.controller.*.*(..))")
//  public void cut() {
//  }

  @Pointcut("execution(* xyz.tangzekk.afi.service.*.*(..))")
  public void cut() {
  }

  @Around("cut()")
  public Object cutAround(ProceedingJoinPoint joinPoint) throws Throwable {
    log.error("[ WebAop ] { cutAround ... before ? }");

    Object proceed = joinPoint.proceed();
    log.error("[ MyInteceptor ] { preHandle ... after ?}");
    //  没有执行  joinPoint.proceed()
    return proceed;
  }
}
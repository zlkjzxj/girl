package com.walle.girl.aspect;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;

/**
 * Created by walle
 * 2017/9/18 22:02
 * good good study,day day up!
 */
@Aspect
@Component
public class HttpAspect {
    //使用log打印，syso太low了
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //    @Before("execution(public * com.walle.girl.controller.GirlAction2.getAGirlList(..))")
    //第一种写法，每个上面写的都一样，太low了，所以写如下方法，让下面方法调用她
//    @Before("execution(public * com.walle.girl.controller.GirlAction2.*(..))")
//    public void log() {
//    }
    @Pointcut("execution(public * com.walle.girl.controller.GirlAction2.*(..))")
        public void log() {
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        System.out.println("111");
        logger.info("111");

        //记录http请求
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = (HttpServletRequest) attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
//        System.out.println("222");
        logger.warn("222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}

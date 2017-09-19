package com.walle.girl.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by walle
 * 2017/9/18 22:02
 * good good study,day day up!
 */
@Aspect
@Component
public class HttpAspect {
//    @Before("execution(public * com.walle.girl.controller.GirlAction2.getAGirlList(..))")
    @Before("execution(public * com.walle.girl.controller.GirlAction2.*(..))")
    public void log(){
        System.out.println(11111);
    }
}

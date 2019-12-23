package com.lee.springboot.dynamic.datasource;

import com.lee.springboot.dynamic.datasource.annotation.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**多数据源切面处理类
 * @author lee
 * @date 2019/12/23 15:59
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect {
    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.lee.springboot.dynamic.datasource.annotation.DataSource)")
    public void dataSourcePointcut() {

    }

    @Around("dataSourcePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法上面的注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 被注解的方法
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);

        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST.name());
            log.info("set datasource is " + DataSourceNames.FIRST.name());
        } else {
            DynamicDataSource.setDataSource(ds.name());
            log.info("set datasource is " + ds.name());
        }

        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.info("clear datasource");
        }
    }
}

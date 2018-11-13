package com.myrom.rpc.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 远程调用朱姐
 *
 * @author mijp
 * @date 2018/6/28 16:59
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcAnnotation {

    /**
     * 对外发布的服务的接口地址
     * */
    Class<?> value();

    String version() default "";
}

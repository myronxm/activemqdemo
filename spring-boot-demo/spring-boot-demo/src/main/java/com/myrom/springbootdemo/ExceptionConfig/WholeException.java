package com.myrom.springbootdemo.ExceptionConfig;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/5/14 18:22
 */
@RestControllerAdvice
public class WholeException {
    
    
    @ExceptionHandler(value = Exception.class)
    public ModelMap exceptionContro(HttpServletRequest request, Exception e) {
        ModelMap map = new ModelMap();
        map.put("内部异常", e.getMessage());
        return map;
    }
}

package org.qingfei.glee.controller;/**
 * Created by ASUS on 6/2/2018.
 */

import org.qingfei.glee.exception.GleeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for handling exceptions
 *
 * @author Jenny Chen
 * @create 2018-06-02 2:53 PM
 */
@ControllerAdvice("org.qingfei.glee.controller")
public class ExceptionHandlingController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GleeException.class)
    public String error(Model model,HttpServletRequest request,GleeException exception) {
        String uri = request.getRequestURI();
        model.addAttribute("message",exception.getMessage());
        return "error";
    }

}

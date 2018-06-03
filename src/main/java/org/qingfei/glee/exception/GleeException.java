package org.qingfei.glee.exception;/**
 * Created by ASUS on 6/2/2018.
 */

/**
 * Exception For the Application
 *
 * @author Jenny Chen
 * @create 2018-06-02 2:43 PM
 */
public class GleeException extends Exception {

    public GleeException(String message) {
        super(message);
    }

    public GleeException(Exception e) {
        super(e);
    }

}

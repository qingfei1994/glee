package org.qingfei.glee.utils;/**
 * Created by ASUS on 6/3/2018.
 */

import org.qingfei.glee.annotation.NotNull;
import org.qingfei.glee.exception.GleeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Utils for validation
 *
 * @author Jenny Chen
 * @create 2018-06-03 4:57 PM
 */
public class ValidationUtil {

    private static final Logger logger = LoggerFactory.getLogger(ValidationUtil.class);

    public static <T> void validate(Class<T> clazz,Object object) throws GleeException{
        Field[] fields =  clazz.getDeclaredFields();
        for (Field field:fields) {
            try {
                if (!checkNotNull(field,object)) {
                    throw new GleeException(field.getName()+"shoud not be empty");
                }
            } catch (IllegalAccessException e) {
                throw new GleeException(e.getMessage());
            }
        }
    }
    public static boolean checkNotNull(Field field,Object obj) throws IllegalAccessException {
        if (field.isAnnotationPresent(NotNull.class)) {
            Object value = getField(field,obj);
            logger.info("field {} -->{}",field.getName(),value);
            if (value==null) {
                return false;
            } else if (value.getClass() == String.class) {
                if (StringUtils.isBlank(value.toString())) {
                    return false;
                }
            }

        }
        return true;
    }
    private static Object getField(Field field, Object obj) throws IllegalAccessException {
        logger.info("field name -->{}",field.getName());
        field.setAccessible(true);
        return field.get(obj);
    }

}

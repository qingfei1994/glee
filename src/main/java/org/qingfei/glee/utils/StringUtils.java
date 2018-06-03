package org.qingfei.glee.utils;/**
 * Created by ASUS on 5/30/2018.
 */

/**
 * Util class for String
 *
 * @author Jenny Chen
 * @create 2018-05-30 6:04 PM
 */
public final class StringUtils {

    private StringUtils(){

    }
    public static boolean isBlank(final String str) {
        return str==null || str.trim().length()==0;
    }
}

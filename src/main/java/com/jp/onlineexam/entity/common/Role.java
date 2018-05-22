package com.jp.onlineexam.entity.common;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/21/2018
 */
public enum Role {
    Teacher,Admin;

    public static Boolean isRole(String role){
        if (Role.Admin.equals( role )||Role.Teacher.equals( role )){
            return true;
        }else{
            return false;
        }
    }
}

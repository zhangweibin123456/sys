package com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.model.UserVO;

/**
 * 用户工具类
 *
 * @author 
 */
public class UserUtil {

    public static final String USER = "user";

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpServletRequest request, UserVO user) {
    	request.setAttribute(USER, user);
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static UserVO getUserFromSession(HttpServletRequest request) {
        Object attribute = request.getAttribute(USER);
        return attribute == null ? null : (UserVO) attribute;
    }

}

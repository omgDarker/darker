package com.vip.darker.system.exception;

/**
 * @Auther: Darker
 * @Date: 2018/7/21 11:15
 * @Description: 登录相关的异常信息
 */
public class LoginException extends RuntimeException {


    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}

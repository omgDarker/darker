package com.vip.darker.exception;

/**
 * @Auther: Darker
 * @Date: 2018/7/21 11:15
 * @Description: 用户相关的异常信息
 */
public class UserException extends RuntimeException {


    public UserException() {

    }

    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}

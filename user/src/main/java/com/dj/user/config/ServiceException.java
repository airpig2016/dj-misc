package com.dj.user.config;

/**
 * Created by dajiechen on 2017/8/7.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(){

    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

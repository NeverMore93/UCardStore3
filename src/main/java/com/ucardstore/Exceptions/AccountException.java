package com.ucardstore.Exceptions;

/**
 * Created by YUAN on 2016/9/5.
 */
public class AccountException extends RuntimeException {
    public AccountException() {
        super();
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }
}

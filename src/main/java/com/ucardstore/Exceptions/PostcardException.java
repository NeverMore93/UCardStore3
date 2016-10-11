package com.ucardstore.Exceptions;

/**
 * Created by YUAN on 2016/9/6.
 */
public class PostcardException extends RuntimeException {
    public PostcardException() {
        super();
    }

    public PostcardException(String message) {
        super(message);
    }

    public PostcardException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostcardException(Throwable cause) {
        super(cause);
    }

    protected PostcardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

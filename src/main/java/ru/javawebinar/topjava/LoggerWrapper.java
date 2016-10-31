package ru.javawebinar.topjava;

import ru.javawebinar.topjava.util.exception.NotFoundException;

/**
 * Created by Администратор on 30.10.16.
 */
public class LoggerWrapper {

    public IllegalStateException getIllegalStateException(String msg) { return getIllegalStateException(msg);}

    public IllegalStateException getIllegalStateException(String msg, Throwable e) {
        logger.error(msg, e);
        return new IllegalStateException(msg, e);
    }

    public IllegalArgumentException getIllegalArgumentException(String msg) { return getIllegalStateException(msg);}

    public IllegalArgumentException getIllegalArgumentException(String msg, Throwable e) {
        logger.error(msg, e);
        return new IllegalArgumentException(msg, e);
    }

    public UnsupportedOperationException getUnsupportedOperationException(String msg) {
        logger.error(msg);
        return new UnsupportedOperationException(msg);
    }

    public NotFoundException getNotFoundException(String reason) {
        logger.error("No data found");
        return  new NotFoundException(reason);
    }



}

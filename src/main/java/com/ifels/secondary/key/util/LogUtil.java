package com.ifels.secondary.key.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final String TAG = "SecondaryKey:";
    private static final Logger log = LoggerFactory.getLogger(TAG);

    public static void d(String fmt, Object... args) {
        String tagFmt = TAG + fmt;
        log.debug(tagFmt, args);
    }

    public static void i(String fmt, Object... args) {
        String tagFmt = TAG + fmt;
        log.info(tagFmt, args);
    }

    public static void w(String fmt, Object... args) {
        String tagFmt = TAG + fmt;
        log.warn(tagFmt, args);
    }

    public static void e(String fmt, Object... args) {
        String tagFmt = TAG + fmt;
        log.error(tagFmt, args);
    }

    public static void e(String msg, Throwable t) {
        String tagMsg = TAG + msg;
        log.error(tagMsg, t);
    }
}

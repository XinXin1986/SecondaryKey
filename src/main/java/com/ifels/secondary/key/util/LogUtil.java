//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ifels.secondary.key.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final String TAG = "SecondaryKey:";
    private static final Logger log = LoggerFactory.getLogger("SecondaryKey");

    public static void d(String fmt, Object... args) {
        String tagFmt = "SecondaryKey:" + fmt;
        log.debug(tagFmt, args);
    }

    public static void i(String fmt, Object... args) {
        String tagFmt = "SecondaryKey:" + fmt;
        log.info(tagFmt, args);
    }

    public static void w(String fmt, Object... args) {
        String tagFmt = "SecondaryKey:" + fmt;
        log.warn(tagFmt, args);
    }

    public static void e(String fmt, Object... args) {
        String tagFmt = "SecondaryKey:" + fmt;
        log.error(tagFmt, args);
    }

    public static void e(String msg, Throwable t) {
        String tagMsg = "SecondaryKey:" + msg;
        log.error(tagMsg, t);
    }
}

package com.example.bank_management_system.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {
    LoggerHelper() {
    }

    public static final String LOG_ERRROR = "Error";
    public static final String LOG_INFO = "Info";
    public static final String LOG_TRACE = "Trace";
    public static final String LOG_DEBUG = "Debug";

    public static Logger getLogger(Class<?> className) {
        return LoggerFactory.getLogger(className);
    }

    public static void log(Logger logger, String format, Object... arguments) {
        log(LOG_ERRROR, logger, format, arguments);
    }

    public static void log(String logLevel, Logger logger, String format, Object... arguments) {

        switch (logLevel) {
            case LOG_ERRROR:
                logger.error(format, arguments);
                break;

            case LOG_INFO:
                logger.info(format, arguments);
                break;

            case LOG_DEBUG:
                logger.debug(format, arguments);
                break;

            case LOG_TRACE:
                logger.trace(format, arguments);
                break;
            default:
                logger.info(format, arguments);
        }
    }

    public static void log(String logLevel, Logger logger, String message) {

        switch (logLevel) {
            case LOG_ERRROR:
                logger.error(message);
                break;

            case LOG_INFO:
                logger.info(message);
                break;

            case LOG_DEBUG:
                logger.debug(message);
                break;
            case LOG_TRACE:
                logger.trace(message);
                break;
            default:
                logger.info(message);
        }
    }

    public static void logError(Logger logger, String message) {
        message = encodeUserInputForLog(message);
        log(LOG_ERRROR, logger, message);
    }

    public static void logInfo(Logger logger, String string) {
        string = encodeUserInputForLog(string);
        log(LOG_INFO, logger, string);
    }

    public static void logDebug(Logger logger, String message) {
        message = encodeUserInputForLog(message);
        log(LOG_DEBUG, logger, message);
    }

    public static void logConstructorEntry(Logger logger, String className) {
        logger.trace("Class '{}' instance instantiation started", className);
    }

    public static void logConstructorExit(Logger logger, String className) {
        logger.trace("Class '{}' instance instantiated", className);
    }

    public static void logMethodEntry(Logger logger, String className, String methodName) {
        logger.trace("Class '{}' method '{}' invoked", className, methodName);
    }

    public static void logMethodExit(Logger logger, String className, String methodName) {
        logger.trace("Class '{}' method '{}' ended", className, methodName);
    }

    public static void logExceptionWithMessage(Logger logger, String message, Exception e) {
        if (message == null || message.isEmpty()) {
            message = "Exception occurred";
        }
        String logMessage = message + " - '{}' - '{}'";
        logMessage = encodeUserInputForLog(logMessage);
        logger.error(logMessage, e.getClass().getName(), e.getMessage());
        logger.trace(logMessage, e.getClass().getName(), e.getMessage(), validateExceptionLength(e));
        logger.debug(logMessage, e.getClass().getName(), e.getMessage(), validateExceptionLength(e));
    }

    public static void logException(Logger logger, Exception e) {
        logException(logger, e.getMessage(), e);
    }

    public static void logException(Logger logger, String message, Exception e) {
        logger.error(message, e);
    }

    private static String encodeUserInputForLog(String input) {
        if (input != null) {
            input = input.replace("\n", "\\\\n");
        }
        return input;
    }

    static String validateUserInputForLog(String input, int len) {
        if (input != null) {
            input = encodeUserInputForLog(input);
            if (input.length() > len) {
                input = input.substring(0, len);
            }
        }
        return input;
    }

    public static String validateLogLength(String input) {
        if (input != null) {
            input = validateUserInputForLog(input, 1024);
        }
        return input;
    }

    public static String validateExceptionLength(Exception e) {
        String exception = null;
        if (e != null) {
            exception = e.toString();
            exception = validateUserInputForLog(exception, 1024);
        }
        return exception;
    }
}


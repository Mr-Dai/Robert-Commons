package com.mrdai.commons.exception;

public abstract class ExceptionHelper {
    private static final StackTraceElement[] EMPTY_TRACE = new StackTraceElement[0];

    public static <T> void checkArgumentNotNull(T argument, String argName) {
        if (argument == null)
            throw new NullPointerException(String.format("Argument `%s` cannot be null.", argName));
    }

    public static void clearStackTrace(Throwable thr) {
        thr.setStackTrace(emptyStackTrace());
    }

    public static StackTraceElement[] emptyStackTrace() {
        return EMPTY_TRACE;
    }

}

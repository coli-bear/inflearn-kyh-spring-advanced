package myl.colibear.study.advanced.trace.callback;

import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {
    private final LogTrace logTrace;

    public TraceTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus traceStatus = null;
        try {
            traceStatus = logTrace.begin(message);
            T t = callback.call();
            logTrace.end(traceStatus);
            return t;
        } catch (Exception e) {
            logTrace.exception(traceStatus, e);
            throw e;
        }
    }
}

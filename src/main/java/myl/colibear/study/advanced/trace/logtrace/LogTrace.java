package myl.colibear.study.advanced.trace.logtrace;

import myl.colibear.study.advanced.trace.TraceStatus;

public interface LogTrace {
    static final String START_PREFIX = "-->";
    static final String COMPLETE_PREFIX = "<--";
    static final String EX_PREFIX = "<X-";
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}

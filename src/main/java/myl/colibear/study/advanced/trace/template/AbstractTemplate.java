package myl.colibear.study.advanced.trace.template;

import myl.colibear.study.advanced.trace.TraceStatus;
import myl.colibear.study.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<R> {
    private final LogTrace logTrace;

    public AbstractTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public R execute(String t) {
        TraceStatus status = null;
        try {
            status = this.logTrace.begin(t);
            R r = this.call();
            this.logTrace.end(status);
            return r;
        } catch (Exception e) {
            this.logTrace.exception(status, e);
            throw e;
        }
    }
    protected abstract R call();
}

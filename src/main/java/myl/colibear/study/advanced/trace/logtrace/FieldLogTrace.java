package myl.colibear.study.advanced.trace.logtrace;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.TraceId;
import myl.colibear.study.advanced.trace.TraceStatus;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class FieldLogTrace implements LogTrace{


    private TraceId traceIdHolder; // trace id 동기화(보관해놓고 사용), 아직 동시성 문제가 있다
    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        Long startTimeMs = System.currentTimeMillis();
        TraceId traceId = this.traceIdHolder;
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    /**
     * TraceId를 새로 만들거나 다음 TraceId를 생성
     */
    private void syncTraceId() {
        if (this.traceIdHolder == null) {
            this.traceIdHolder = new TraceId();
        } else {
            this.traceIdHolder = this.traceIdHolder.createNextId();
        }

    }

    @Override
    public void end(TraceStatus status) {
        this.complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        this.complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, e.toString());
        }
        releaseTraceId();
    }

    /**
     * TraceId를 제거하거나 이전 TraceId를 생성
     */
    private void releaseTraceId() {
        if (this.traceIdHolder.isFirstLevel()) {
            this.traceIdHolder = null; // destroy
        } else {
            this.traceIdHolder.createPreviousId();
        }
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }


}

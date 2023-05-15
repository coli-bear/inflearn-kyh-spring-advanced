package myl.colibear.study.advanced.trace.logtrace;

import lombok.extern.slf4j.Slf4j;
import myl.colibear.study.advanced.trace.TraceId;
import myl.colibear.study.advanced.trace.TraceStatus;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class ThreadLogTrace implements LogTrace {

    /**
     * 사용시 주의 사항 !!!!!
     * Thread 는 생송 비용이 비싸기 때문에 ThreadPool 에 넣어놓고 재사용한다.
     * <p>
     * 사용자 A 가 Thread A 를 사용(사용자 A 의 정보를 ThreadLocal에 저장()하고 반납 한경우에 ThreadPool 에 사용한 Thread A 는 남아있게 된다.
     * 이때 사용자 B 가 요청시 만약 Thread A 를 사용하면서, 조회만 사용하는 경우에 사용자 B는 사용자 A의 정보를 조회하게 된다.
     * <p>
     * 그렇기 요청처리가 끝난 경우 filter 나 interceptor 에서 remove 를 꼭 해야 한다.
     */
    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        Long startTimeMs = System.currentTimeMillis();
        TraceId traceId = getTraceId();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    /**
     * TraceId를 새로 만들거나 다음 TraceId를 생성
     */
    private void syncTraceId() {
        if (getTraceId() == null) {
            this.traceIdHolder.set(new TraceId());
        } else {
            this.traceIdHolder.set(getTraceId().createNextId());
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
        if (getTraceId().isFirstLevel()) {
            this.traceIdHolder.remove();
        } else {
            this.traceIdHolder.set(getTraceId().createPreviousId());
        }
    }

    private TraceId getTraceId() {
        return this.traceIdHolder.get();
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }


}

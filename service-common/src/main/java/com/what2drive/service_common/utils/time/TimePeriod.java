package com.what2drive.service_common.utils.time;

public class TimePeriod {
    private long start;
    private long end;

    public TimePeriod(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
}
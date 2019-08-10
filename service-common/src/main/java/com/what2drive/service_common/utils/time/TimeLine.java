package com.what2drive.service_common.utils.time;

import java.util.LinkedList;
import java.util.List;

public class TimeLine {
    private List<TimePeriod> periods;

    public TimeLine(List<TimePeriod> periods) {
        this.periods = periods;
    }

    public TimeLine(long start, long end, long step) {
        this.periods = new LinkedList<>();

        // For each period
        for (long currentTime = start; currentTime < end; currentTime += step) {
            // Determine start/end of this period
            long periodStart = currentTime;
            long periodEnd = periodStart + step;

            periods.add(new TimePeriod(periodStart, periodEnd));
        }
    }

    public List<TimePeriod> getPeriods() {
        return periods;
    }
}
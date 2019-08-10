package com.what2drive.service_common.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * Util class to ease time related operations
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:02
 */
public final class Time {
    /**
     * Private default constructor
     * Prevents instantiation of this class
     */
    private Time() {
        throw new IllegalAccessError();
    }

    /**
     * Current time
     */
    public final static class Current {
        /**
         * Private default constructor
         * Prevents instantiation of this class
         */
        private Current() {
            throw new IllegalAccessError();
        }

        /**
         * Get current time as {@link Timestamp} object
         * @return timestamp
         */
        public static Timestamp getAsTimestamp() {
            return new Timestamp(System.currentTimeMillis());
        }

        /**
         * Get current time as timestamp but in {@link Long} format
         * @return timestamp as long
         */
        public static long getAsLong() {
            return getAsTimestamp().getTime();
        }

        /**
         * Get current time as {@link Date} object
         * @return timestamp as date
         */
        public static Date getAsDate() {
            return new Date(getAsLong());
        }

        /**
         * Get current timezone offset (in minutes)
         * Ex: GMT +3 = 180; GMT -3 = -180
         * @return
         */
        public static long getTimezoneOffset() {
            Calendar calendar = new GregorianCalendar();
            return - (calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET)) / (60 * 1000);
        }
    }

    public final static class Seconds {
        public static long millis(long numberOfSeconds) {
            return TimeUnit.SECONDS.toMillis(numberOfSeconds);
        }
    }

    public static class Minutes {
        public static long millis(long numberOfMinutes) {
            return TimeUnit.MINUTES.toMillis(numberOfMinutes);
        }

        public static long millis(double numberOfMinutes) {
            return (long) (numberOfMinutes * 60 * 1000);
        }
    }

    public static class Hours {
        public static long millis(long numberOfHours) {
            return TimeUnit.HOURS.toMillis(numberOfHours);
        }

        public static int fromDuration(long durationInMilliseconds) {
            return (int) (durationInMilliseconds / (1000 * 60 * 60));
        }
    }

    public static class Days {
        public static long millis(long numberOfDays) {
            return TimeUnit.DAYS.toMillis(numberOfDays);
        }

        public static int fromDuration(long durationInMilliseconds) {
            return (int) (durationInMilliseconds / (1000 * 60 * 60 * 24));
        }
    }

    public static class Weeks {
        public static long millis(long numberOfWeeks) {
            return Days.millis(numberOfWeeks * 7);
        }
    }

    public static class Months {
        public static long millis(long numberOfMonths) {
            return Days.millis(numberOfMonths * 30);
        }
    }

    public static class Years {
        public static long millis(long numberOfYears) {
            return Days.millis(numberOfYears * 365);
        }
    }

    public static class Timezone {
        public static long adjustToClientTimezone(long timestampAtServerTimezone, long clientTimezoneOffset) {
            long serverTimezoneOffset = Time.Current.getTimezoneOffset();
            long deltaOffset = serverTimezoneOffset - clientTimezoneOffset;
            return timestampAtServerTimezone + (deltaOffset * 60 * 1000);
        }

        public static long adjustToServerTimezone(long timestampAtClientTimezone, long clientTimezoneOffset) {
            long serverTimezoneOffset = Time.Current.getTimezoneOffset();
            long deltaOffset = clientTimezoneOffset - serverTimezoneOffset;
            return timestampAtClientTimezone + (deltaOffset * 60 * 1000);
        }
    }

    public static class DayTime {
        public static long getHourInDay(long millis) {
            return (millis % 86400000) / 3600000;
        }
    }
}
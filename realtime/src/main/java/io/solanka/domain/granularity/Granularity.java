package io.solanka.domain.granularity;


import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * The granularity of data
 */
public enum Granularity {

    SECOND(Duration.of(1, ChronoUnit.SECONDS)) {
        @Override
        public ZonedDateTime truncate(ZonedDateTime time) {
            return time.truncatedTo(ChronoUnit.SECONDS);
        }


        @Override
        public String getPattern() {
            return "yyyy-MM-dd-HH-mm-ss";
        }
    },

    HOUR(Duration.of(1, ChronoUnit.HOURS)) {
        @Override
        public ZonedDateTime truncate(ZonedDateTime time) {
            return time.truncatedTo(ChronoUnit.HOURS);
        }

        @Override
        public String getPattern() {
            return "yyyy-MM-dd-HH";
        }
    },

    DAY(Duration.of(1, ChronoUnit.DAYS)) {
        @Override
        public ZonedDateTime truncate(ZonedDateTime time) {
            return time.truncatedTo(ChronoUnit.DAYS);
        }

        @Override
        public String getPattern() {
            return "yyyy-MM-dd";
        }

    };

    public abstract ZonedDateTime truncate(ZonedDateTime time);

    public String format(ZonedDateTime time) {
        return DateTimeFormatter
                .ofPattern(getPattern())
                .format(time);
    }

    public abstract String getPattern();

    public Duration duration() {
        return duration;
    }

    public static String defaultFormat(ZonedDateTime time) {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd-HH-mm-ss").format(time);
    }

    Duration duration;

    Granularity(Duration duration) {
        this.duration = duration;
    }
}

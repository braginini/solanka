package io.solanka.domain.strategy;

import java.time.Duration;

/**
 * The strategy that accepts timestamp if it is not too old and not too young comparing to current time on server
 */
public class ServerTimestampRejectionStrategy implements TimestampRejectionStrategy {

    final Duration window;

    /**
     * Creates an instance with given duration (time window)
     *
     * @param window the time window
     */
    public ServerTimestampRejectionStrategy(Duration window) {
        this.window = window;
    }

    /**
     * Accepts timestamp if it fits the window
     * @param timestamp the timestamp to check
     * @return {@code true} if accepted, {@code false} otherwise
     */
    public boolean accept(long timestamp) {
        long now = System.currentTimeMillis();
        boolean notOld = timestamp >= (now - window.toMillis());
        boolean notYoung = timestamp <= (now + window.toMillis());
        return notOld && notYoung;
    }

    @Override
    public long maxAccepted() {
        return System.currentTimeMillis() + window.toMillis();
    }

}

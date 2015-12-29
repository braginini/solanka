package io.solanka.domain.strategy;

import java.util.concurrent.TimeUnit;

/**
 * The strategy that accepts timestamp if it is new enough
 */
public class SimpleRejectionStrategy implements RejectionStrategy {

    final long time;
    final TimeUnit timeUnit;

    /**
     * Creates an instance with given time threshold and corresponding {@link TimeUnit}
     *
     * @param time the time threshold
     * @param timeUnit the unit of {@code time} parameter
     */
    public SimpleRejectionStrategy(long time, TimeUnit timeUnit) {
        this.time = time;
        this.timeUnit = timeUnit;
    }

    /**
     * Accepts timestamp if it is bigger or equal to now - time threshold
     * @param timestamp
     * @return {@code true} if accepted, {@code false} otherwise
     */
    public boolean accept(long timestamp) {
        long now = System.currentTimeMillis();
        return timestamp >= (now - timeUnit.toMillis(time));
    }

}

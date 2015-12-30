package io.solanka.domain.strategy;

/**
 * The strategy that determines if timestamp should be accepted or rejected.
 * Used to accept/reject events based on timestamp.
 */
public interface TimestampRejectionStrategy {

    /**
     * accepts or rejects timestamp
     *
     * @param timestamp the timestamp to check
     * @return {@code true} if accepted, {@code false} otherwise
     */
    boolean accept(long timestamp);

    /**
     * get the maximum accepted timestamp
     *
     * @return maximum accepted timestamp in millis
     */
    long maxAccepted();
}

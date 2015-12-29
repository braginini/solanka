package io.solanka.domain.strategy;

/**
 * The strategy that determines if timestamp should be accepted or rejected.
 * Used to accept/reject events based on timestamp.
 */
public interface RejectionStrategy {

    boolean accept(long timestamp);
}

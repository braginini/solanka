package io.solanka.domain.strategy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ServerTimestampRejectionStrategyTest {

    Duration duration = Duration.ofMillis(100L);

    ServerTimestampRejectionStrategy strategy;

    @BeforeClass
    public void setUp() {
        strategy = new ServerTimestampRejectionStrategy(duration);
    }


    /**
     * When timestamp newer then or equal to (now - threshold)
     * then should accept
     */
    @Test
    public void shouldAccept() {
        long timestamp = System.currentTimeMillis();
        assertTrue(strategy.accept(timestamp));
    }

    /**
     * When timestamp older then (now - threshold)
     * then should reject
     */
    @Test
    public void shouldReject() {
        long timestamp = System.currentTimeMillis() - duration.toMillis() - 1L;
        assertFalse(strategy.accept(timestamp));

        timestamp = System.currentTimeMillis() + duration.toMillis() + 1L;
        assertFalse(strategy.accept(timestamp));
    }
}

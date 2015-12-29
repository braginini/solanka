package io.solanka.domain.strategy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SimpleRejectionStrategyTest {

    long threshold;
    TimeUnit timeUnit;

    SimpleRejectionStrategy strategy;

    @BeforeClass
    public void setUp() {
        threshold = 100L;
        timeUnit= TimeUnit.MILLISECONDS;
        strategy = new SimpleRejectionStrategy(threshold, timeUnit);
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
        long timestamp = System.currentTimeMillis() - timeUnit.toMillis(threshold) - 1L;
        assertFalse(strategy.accept(timestamp));
    }
}

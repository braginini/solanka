package io.solanka.domain.granularity;

import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class GranularityTest {

    @Test
    public void testSecond() {
        ZonedDateTime now = ZonedDateTime.now();
        Granularity granularity = Granularity.SECOND;
        String formatted = DateTimeFormatter
                .ofPattern(granularity.getPattern())
                .format(now);

        assertEquals(granularity.duration().getSeconds(), 1L);
        assertEquals(formatted, granularity.format(now));
    }

    @Test
    public void testHour() {
        ZonedDateTime now = ZonedDateTime.now();
        Granularity granularity = Granularity.HOUR;
        String formatted = DateTimeFormatter
                .ofPattern(granularity.getPattern())
                .format(now);

        assertEquals(granularity.duration().toMillis(), 60 * 60 * 1000L);
        assertEquals(formatted, granularity.format(now));
    }

    @Test
    public void testDay() {
        ZonedDateTime now = ZonedDateTime.now();
        Granularity granularity = Granularity.DAY;
        String formatted = DateTimeFormatter
                .ofPattern(granularity.getPattern())
                .format(now);

        assertEquals(granularity.duration().toMillis(), 24 * 60 * 60 * 1000L);
        assertEquals(formatted, granularity.format(now));
    }
}

package io.solanka.common.event;

import io.solanka.common.event.MapEvent;
import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

/**
 *
 */
public class MapEventTest {

    @Test
    public void test() {

        Supplier<Stream<String>> supplier =
                () -> Stream.of("dim_1", "dim_2", "dim_null");

        Map<String, Object> body = new HashMap<>(3);
        supplier.get().forEach((e -> {
            if ("dim_null".equals(e))
                body.put(e, null);
            else body.put(e, e);
        }));

        MapEvent event = new MapEvent(ZonedDateTime.now(), body, supplier.get().collect(Collectors.toList()));
        //when null value
        //then empty String
        assertTrue(event.getDimension("dim_null").isEmpty());

        //when not null value
        //then it is equal to input
        assertEquals(event.getDimension("dim_2"), "dim_2");

        //when 3 dims
        //then dim list is size of 3
        assertTrue(event.getDimensions().size() == 3);
    }
}

package io.solanka.domain.event;

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
        //then empty list
        assertTrue(event.getDimension("dim_null").isEmpty());

        //when not null and single value
        //then size = 1
        assertTrue(event.getDimension("dim_2").size() == 1);

        //when 3 dims
        //then dim list is size of 3
        assertTrue(event.getDimensions().size() == 3);
    }
}

package io.solanka.common.event;

import java.time.ZonedDateTime;
import java.util.*;

/**
 * An {@link Event} interface implementation backed by {@link java.util.Map}.
 * Map holds dimension -> value(s) mapping
 */
public class MapEvent implements Event {

    private final ZonedDateTime timestamp;

    private final Map<String, Object> body;

    private final List<String> dimensions;

    public MapEvent(ZonedDateTime timestamp,
                    Map<String, Object> body,
                    List<String> dimensions) {
        this.timestamp = timestamp;
        this.body = body;
        this.dimensions = dimensions;
    }


    @Override
    public List<String> getDimensions() {
        return dimensions;
    }

    @Override
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public long getTimestampMillis() {
        return timestamp.toInstant().toEpochMilli();
    }

    @Override
    public Object getRawDimension(String dimension) {
        return body.get(dimension);
    }

    @Override
    public String getDimension(String dimension) {

        final Object value = body.get(dimension);
        if (value == null) {
            return "";
        } else {
            return String.valueOf(value);
        }
    }
}

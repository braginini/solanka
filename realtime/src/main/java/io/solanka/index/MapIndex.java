package io.solanka.index;

import io.solanka.common.event.Event;
import io.solanka.domain.dataschema.DataSchema;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implements {@link Index} interface and uses {@link HashMap} as a storage.
 */
public class MapIndex implements Index {

    private final HashMap<String, Long> index = new HashMap<>();

    //incremented when add event
    private final AtomicInteger increment = new AtomicInteger(0);

    private final DataSchema dataSchema;

    //defines maximum number of events
    private final int capacity;

    public MapIndex(DataSchema dataSchema, int capacity) {
        this.dataSchema = dataSchema;
        this.capacity = capacity;
    }

    @Override
    public void addEvent(Event event) {

    }
}

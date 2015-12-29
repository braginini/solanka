package io.solanka.index;

import io.solanka.domain.messages.AddEvent;

import java.util.HashMap;

/**
 *
 */
public class SegmentIndex {

    final HashMap<String, Long> index = new HashMap<>();

    void add(AddEvent event) {
        index.put(event.getBody(), event.getTimestamp());
    }

}

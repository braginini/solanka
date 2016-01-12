package io.solanka.index;

import io.solanka.common.event.Event;

/**
 * The interface that defines index operations.
 */
public interface Index {

    /**
     * Adds {@link Event} to index
     *
     * @param event the event to add
     */
    void addEvent(Event event);
}

package io.solanka.common.event;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * An interface that defines an input object of the system - event.
 * Each event keeps a list of dimensions so that they could be added dynamically.
 */
public interface Event {

    /**
     * Gets dimensions of an event
     *
     * @return the list of dimensions
     */
    List<String> getDimensions();

    /**
     * Gets event timestamp represented by {@link ZonedDateTime}
     *
     * @return event's timestamp
     */
    ZonedDateTime getTimestamp();

    /**
     * Gets event timestamp in millis since epoch
     *
     * @return event's timestamp in millis since epoch
     */
    long getTimestampMillis();

    /**
     * Gets raw value of a given dimension
     *
     * @param dimension the dimension
     * @return the raw value
     */
    Object getRawDimension(String dimension);

    /**
     * Gets all values of a given dimension.
     * Converts all values to Strings
     *
     * @param dimension the dimension
     * @return thew {@link List} of all dimension values represented as strings
     */
    String getDimension(String dimension);

}

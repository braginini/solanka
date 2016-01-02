package io.solanka.common.event.parser;

import io.solanka.common.event.Event;

/**
 * Interface that describes parser behaviour for {@link Event}
 */
public interface EventParser<T, V extends Event> {

    /**
     * Parses given raw event
     *
     * @param raw the raw event body to parse
     * @return parsed event of type V
     * @throws Exception when any parse exception occurs
     */
    V parse(T raw) throws Exception;
}

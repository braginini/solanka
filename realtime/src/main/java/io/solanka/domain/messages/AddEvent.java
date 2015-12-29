package io.solanka.domain.messages;

import java.io.Serializable;

/**
 *
 */
public class AddEvent implements Serializable {

    final String body;
    final long timestamp;

    public AddEvent(String body, long timestamp) {
        this.body = body;
        this.timestamp = timestamp;
    }

    public String getBody() {
        return body;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

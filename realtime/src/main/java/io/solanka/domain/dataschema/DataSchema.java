package io.solanka.domain.dataschema;

import io.solanka.domain.granularity.Granularity;

/**
 * The schema of data
 *
 */
public class DataSchema {

    final Granularity granularity;

    public DataSchema(Granularity granularity) {
        this.granularity = granularity;
    }

    public Granularity getGranularity() {
        return granularity;
    }
}

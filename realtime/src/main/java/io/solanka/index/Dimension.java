package io.solanka.index;

/**
 * The actual holder of dimension values that is used by {@link Index}
 * to store {@link io.solanka.common.event.Event} data using inverted indices.
 *
 * For each unique dimension value the id must be generated.
 */
public interface Dimension {

    /**
     * Adds given dimension value
     *
     * @param value the value of a dimension to be added
     * @return the id of a value
     */
    int add(String value);

    /**
     * Gets a value by given id
     *
     * @param id the id of a value to get
     * @return value
     */
    String getValue(int id);

    /**
     * Gets id of a value
     *
     * @param value the value to get by
     * @return id
     */
    int getId(String value);

    /**
     * Returns the size of the dimension
     *
     * @return size of the dimension
     */
    int size();
}

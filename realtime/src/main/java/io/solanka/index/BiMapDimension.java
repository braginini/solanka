package io.solanka.index;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * The implementation of {@link Dimension} interface backed by Guava's {@link BiMap}.
 */
public class BiMapDimension implements Dimension {

    private final BiMap<String, Integer> biMap;

    public BiMapDimension() {
        this.biMap = HashBiMap.create();
    }

    @Override
    public int add(String value) {
        int id = biMap.size();
        biMap.put(value, id);
        return id;
    }

    @Override
    public String getValue(int id) {
        return biMap.inverse().get(id);
    }

    public int getId(String value) {
        return biMap.get(value);
    }

    @Override
    public int size() {
        return biMap.size();
    }
}

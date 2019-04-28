package io.xtests.mock.store;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author patrick
 */
@Component
public class GenericMockMemStore {

    private ConcurrentHashMap<String, Object> mockStore = new ConcurrentHashMap<>();

    public void saveMock(String key, Object value) {
        this.mockStore.put(key, value);
    }

    public Object getMock(String key) {
        return this.mockStore.get(key);
    }

}

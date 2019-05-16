package io.qkits.common.generator;

import java.util.Random;

/**
 * @author patrick
 */
public abstract class GenericGenerator {
    /**
     * Generate String for Test Data
     * @return
     */
    public abstract String generate();

    private static Random random = null;

    protected Random getRandomInstance() {
        if (random == null) {
            random = new Random(System.currentTimeMillis());
        }

        return random;
    }
}

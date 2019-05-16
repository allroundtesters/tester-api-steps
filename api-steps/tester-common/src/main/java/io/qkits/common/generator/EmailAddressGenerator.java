package io.qkits.common.generator;

import org.apache.commons.lang3.RandomStringUtils;


/**
 * @author patrick
 */
public class EmailAddressGenerator extends GenericGenerator {
    private static GenericGenerator instance = new EmailAddressGenerator();

    private EmailAddressGenerator() {
    }

    public static GenericGenerator getInstance() {
        return instance;
    }

    @Override
    public String generate() {

        String result = RandomStringUtils.randomAlphanumeric(10) +
            "@" +
            RandomStringUtils.randomAlphanumeric(5) +
            "." +
            RandomStringUtils.randomAlphanumeric(3);
        return result.toLowerCase();
    }
}

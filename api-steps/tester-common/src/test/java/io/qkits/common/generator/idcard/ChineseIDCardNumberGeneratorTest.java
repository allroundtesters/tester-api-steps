package io.qkits.common.generator.idcard;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChineseIDCardNumberGeneratorTest {

    @Test
    public void generate() {
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        System.out.println(idCard);
    }
}

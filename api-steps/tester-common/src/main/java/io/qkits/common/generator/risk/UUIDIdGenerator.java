package io.qkits.common.generator.risk;

import java.util.UUID;

public class UUIDIdGenerator implements RiskIdGenerator {

    public String getId(String scene) {
        return scene + "_" + UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

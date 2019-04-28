package io.xtests.mock.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author patrick
 */
@Data
@Builder
public class MockSetupResponse {
    private int code;
    private String msg;

    public static MockSetupResponse success() {
        return MockSetupResponse.builder().code(1)
                .msg("success").build();
    }

    public static MockSetupResponse fail() {
        return MockSetupResponse.builder().code(0)
                .msg("success").build();
    }
}

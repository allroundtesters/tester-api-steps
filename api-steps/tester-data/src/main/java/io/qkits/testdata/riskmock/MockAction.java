package io.qkits.testdata.riskmock;

import io.qkits.testdata.riskmock.thirdparty.TPMockResponse;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Mock Action Interface for different risk rule configuration
 *
 * @author patrick
 */
public interface MockAction {
    /**
     * setup default mock
     *
     * @return
     */
    public TPMockResponse defaultMock();

    /**
     * set up mock by given mock configuration
     *
     * @param mockActionConfig
     * @return
     */
    public TPMockResponse mock(String mockActionConfig);

    /**
     * setup mock by specific configuration
     * Default is not implemented as in most case it is not used
     *
     * @param mockActionConfig
     * @return
     */
    default public TPMockResponse customMock(String mockActionConfig) {
        throw new NotImplementedException("not implemented!");
    }

}

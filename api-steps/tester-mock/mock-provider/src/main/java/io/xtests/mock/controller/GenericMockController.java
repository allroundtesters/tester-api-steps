package io.xtests.mock.controller;

import io.xtests.mock.response.GenericMockResponse;
import io.xtests.mock.response.MockSetupResponse;
import io.xtests.mock.store.GenericMockMemStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author patrick
 */
@RestController
@RequestMapping("/mock")
@Profile("test")
public class GenericMockController {

    @Autowired
    private GenericMockMemStore mockMemStore;

    @RequestMapping("/{productName}/setup")
    @PostMapping
    public MockSetupResponse setupMock(@RequestBody GenericMockResponse setupResponse,
                                       @PathVariable String productName,
                                       HttpServletRequest request){

        mockMemStore.saveMock(productName,setupResponse);
        return MockSetupResponse.success();
    }

    @RequestMapping(value = "/{productName}/getMock",method = {RequestMethod.GET,
                                                                RequestMethod.POST,RequestMethod.PUT})
    public Object getMock(@PathVariable String productName,
                                       HttpServletRequest request){

       return  mockMemStore.getMock(productName);
    }
}

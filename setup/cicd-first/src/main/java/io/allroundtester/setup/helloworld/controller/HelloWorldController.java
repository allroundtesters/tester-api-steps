package io.allroundtester.setup.helloworld.controller;

import io.allroundtester.setup.common.web.BaseResponse;
import io.allroundtester.setup.helloworld.dto.HelloWorldDTO;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld/{id}")
    public BaseResponse<HelloWorldDTO> getHelloWorld(@PathVariable Long id) {
        return BaseResponse.builder().OK().data(HelloWorldDTO.builder().id(id).msg("Hello World").build());

    }


    @PostMapping("/HelloWorld")
    public BaseResponse<HelloWorldDTO> createHelloWorld(@RequestBody HelloWorldDTO requestBody) {
        return BaseResponse.builder().OK().data(requestBody);
    }

    @PutMapping("/HelloWorld/{id}")
    public BaseResponse<HelloWorldDTO> updateHelloWorld(@PathVariable Long id, @RequestBody HelloWorldDTO updateData) {

        return BaseResponse.builder().OK().data(updateData);
    }

    @DeleteMapping("/HelloWorld/{id}")
    public BaseResponse<HelloWorldDTO> deleteHelloWorld(@PathVariable Long id) {
        return BaseResponse.builder().OK().data(HelloWorldDTO.builder().id(id).msg("deleted!").build());
    }
}

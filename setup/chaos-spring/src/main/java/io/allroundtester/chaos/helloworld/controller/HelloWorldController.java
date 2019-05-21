package io.allroundtester.chaos.helloworld.controller;


import io.allroundtester.chaos.BaseResponse;
import io.allroundtester.chaos.helloworld.dto.HelloWorldDTO;
import org.springframework.web.bind.annotation.*;


/**
 * @author patrick
 */
@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld/{id}")
    public BaseResponse getHelloWorld(@PathVariable Long id) {
        return BaseResponse.OK().data(HelloWorldDTO.builder().id(id).msg("Hello World").build());

    }


    @PostMapping("/HelloWorld")
    public BaseResponse<HelloWorldDTO> createHelloWorld(@RequestBody HelloWorldDTO requestBody) {
        return BaseResponse.OK().data(requestBody);
    }

    @PutMapping("/HelloWorld/{id}")
    public BaseResponse<HelloWorldDTO> updateHelloWorld(@PathVariable Long id, @RequestBody HelloWorldDTO updateData) {

        return BaseResponse.OK().data(updateData);
    }

    @DeleteMapping("/HelloWorld/{id}")
    public BaseResponse<HelloWorldDTO> deleteHelloWorld(@PathVariable Long id) {
        return BaseResponse.OK().data(HelloWorldDTO.builder().id(id).msg("deleted!").build());
    }
}

package io.allroundtester.setup.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld/{id}")
    public String getHelloWorld(@PathVariable Long id) {
        return String.format("Get Hello World for Id %d", id);
    }


    @PostMapping("/HelloWorld")
    public String createHelloWorld(@RequestBody String requestBody) {
        return String.format("Post Hello World with request body %s", requestBody);
    }

    @PutMapping("/HelloWorld/{id}")
    public String updateHelloWorld(@PathVariable Long id, @RequestBody String updateData) {

        return String.format("Modify Hello World for id %d,modified %s", id,updateData);
    }

    @DeleteMapping("/HelloWorld/{id}")
    public String deleteHelloWorld(@PathVariable Long id) {
        return String.format("Delete Hello World for id %d", id);
    }
}

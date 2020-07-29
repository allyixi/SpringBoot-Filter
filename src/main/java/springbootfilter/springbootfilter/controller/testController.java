package springbootfilter.springbootfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/filterTest")
    public String filterTest() {
        return "没有拦截到我！";
    }
}

package indi.wyx0k.demo.serverhelloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/ok/{i}")
    public String t (@PathVariable int i){
        return "hello_world"+ i;
    }
}

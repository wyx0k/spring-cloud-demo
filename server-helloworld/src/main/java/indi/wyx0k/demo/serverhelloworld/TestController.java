package indi.wyx0k.demo.serverhelloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @RequestMapping("/ok/{i}")
    public String t (@PathVariable int i){
        return "hello_world"+ i + "port" + port;
    }
}

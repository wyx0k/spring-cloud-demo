package indi.wyx0k.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConsumerController {

    TestService testService;

    public TestService getTestService() {
        return testService;
    }
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/ok/{i}")
    public String ok(@PathVariable int i){
       return  testService.ok(i);
    }
}

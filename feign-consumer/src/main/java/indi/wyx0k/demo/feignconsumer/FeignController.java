package indi.wyx0k.demo.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    FeignService feignService;

    public FeignService getFeignService() {
        return feignService;
    }
    @Autowired
    public void setFeignService(FeignService feignService) {
        this.feignService = feignService;
    }

    @GetMapping("/ok/{i}")
    String ok(@PathVariable int i){
        return feignService.ok(i);
    }
}

package indi.wyx0k.demo.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="service-helloworld",fallback = FallbackFeignService.class)
public interface FeignService {
    @GetMapping("/ok/{i}")
    String ok (@PathVariable("i") int i);
}

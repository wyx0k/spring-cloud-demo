package indi.wyx0k.demo.feignconsumer;

import org.springframework.stereotype.Component;

@Component
public class FallbackFeignService implements FeignService{
    @Override
    public String ok(int i) {
        return "我擦,竟然失效了";
    }
}

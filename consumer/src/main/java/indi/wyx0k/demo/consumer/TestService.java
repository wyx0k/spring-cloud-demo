package indi.wyx0k.demo.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resources;

@Service("testService")
public class TestService {

    RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "error")
    public String ok(int i){
        String url = "http://service-helloworld/ok/" + i;
        return restTemplate.getForObject(url,String.class);
    }

    public  String error (int i) {
        return "不好意思,服务暂不可用";
    }
}

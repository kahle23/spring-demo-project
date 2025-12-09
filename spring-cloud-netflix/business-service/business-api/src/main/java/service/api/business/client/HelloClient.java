package service.api.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.api.business.fallback.HelloClientHystrix;
import service.api.business.input.HelloInput;
import service.api.business.result.HelloResult;

@FeignClient(value = "business-service", fallback = HelloClientHystrix.class)
public interface HelloClient {

    @RequestMapping(value = "/api/index", method = RequestMethod.GET)
    String index();

    @RequestMapping(value = "/api/hello", method = RequestMethod.POST)
    HelloResult hello(@RequestBody HelloInput helloInput);

}

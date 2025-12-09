package service.api.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.api.business.fallback.TimeClientHystrix;

@FeignClient(value = "business-service", fallback = TimeClientHystrix.class)
public interface TimeClient {

    @RequestMapping(value = "/api/time", method = RequestMethod.POST)
    String time(@RequestParam("pattern") String pattern);

}

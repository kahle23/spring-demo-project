package service.api.business.fallback;

import org.springframework.stereotype.Component;
import service.api.business.client.TimeClient;

@Component
public class TimeClientHystrix implements TimeClient {

    @Override
    public String time(String patten) {

        return "Hystrix! ";
    }

}

package service.api.business.fallback;

import org.springframework.stereotype.Component;
import service.api.business.client.HelloClient;
import service.api.business.input.HelloInput;
import service.api.business.result.HelloResult;

@Component
public class HelloClientHystrix implements HelloClient {

    @Override
    public String index() {

        return "Hystrix! ";
    }

    @Override
    public HelloResult hello(HelloInput helloInput) {
        HelloResult result = new HelloResult();
        result.setContent("Hystrix! ");
        result.setStatus("-1");
        return result;
    }

}

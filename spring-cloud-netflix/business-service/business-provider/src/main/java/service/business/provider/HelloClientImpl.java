package service.business.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import service.api.business.client.HelloClient;
import service.api.business.input.HelloInput;
import service.api.business.result.HelloResult;

@RestController
public class HelloClientImpl implements HelloClient {
    private static Logger log = LoggerFactory.getLogger(HelloClientImpl.class);

    @Override
    public String index() {

        return "Hello, World. ";
    }

    @Override
    public HelloResult hello(HelloInput helloInput) {
        HelloResult result = new HelloResult();
        if (helloInput == null) {
            result.setStatus("0");
            result.setContent("");
            return result;
        }
        String name = helloInput.getName();
        result.setContent("Hello, " + name + ". ");
        result.setStatus("1");
        return result;
    }

}

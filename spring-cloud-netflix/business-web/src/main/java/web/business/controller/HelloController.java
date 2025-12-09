package web.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.business.client.HelloClient;
import service.api.business.input.HelloInput;
import service.api.business.result.HelloResult;

@Controller
public class HelloController {

    @Autowired
    private HelloClient helloClient;

    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return helloClient.index();
    }

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public HelloResult hello(HelloInput helloInput) {

        return helloClient.hello(helloInput);
    }

}

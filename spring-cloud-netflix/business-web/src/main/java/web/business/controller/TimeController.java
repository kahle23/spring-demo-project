package web.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.api.business.client.TimeClient;

@Controller
public class TimeController {

    @Autowired
    private TimeClient timeClient;

    @ResponseBody
    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String time(String pattern) {

        return timeClient.time(pattern);
    }

}

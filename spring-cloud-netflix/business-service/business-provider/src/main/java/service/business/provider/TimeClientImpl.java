package service.business.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import service.api.business.client.TimeClient;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TimeClientImpl implements TimeClient {
    private static Logger log = LoggerFactory.getLogger(TimeClientImpl.class);

    @Override
    public String time(String pattern) {
        if (pattern == null || pattern.trim().length() == 0) {
            pattern = "yyyy-MM-dd HH:mm:ss SSS";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }

}

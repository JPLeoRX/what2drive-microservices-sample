package com.what2drive.car_service;

import com.what2drive.message_protocol.Car;
import com.what2drive.service_common.resource.ReplyObject;
import com.what2drive.service_common.resource.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController @RequestMapping("/")
public class CarResource implements Resource {
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ReplyObject getAll() {
        try {
            Car car = new Car("Honda", "Accord", "MK7", "Sedan");
            return ReplyObject.Builder.success("cars", Arrays.asList(car)).build();
        }

        catch (Exception e) {
            return this.getDefaultErrorReplyObject(e);
        }
    }
}
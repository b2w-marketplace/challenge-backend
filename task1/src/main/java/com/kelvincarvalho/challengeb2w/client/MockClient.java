package com.kelvincarvalho.challengeb2w.client;

import com.kelvincarvalho.challengeb2w.model.OrderDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Headers("Content-Type: application/json")
@FeignClient(name = "mock", url = "${mocky.url:}")
public interface MockClient {

    @RequestMapping(method = RequestMethod.GET, value = "/5817803a1000007d01cc7fc9")
    List<OrderDTO> listOrder();

}

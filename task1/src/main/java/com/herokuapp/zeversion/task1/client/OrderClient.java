package com.herokuapp.zeversion.task1.client;

import com.herokuapp.zeversion.task1.model.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name = "order", url = "http://www.mocky.io/v2")
public interface OrderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/5817803a1000007d01cc7fc9")
    List<OrderDTO> getItens();
}

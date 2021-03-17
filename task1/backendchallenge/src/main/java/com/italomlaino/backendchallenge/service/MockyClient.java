package com.italomlaino.backendchallenge.service;

import com.italomlaino.backendchallenge.dto.ItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "mockyClient", url = "${mockyclient.url}")
public interface MockyClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "${mockyclient.fetch.path}")
    List<ItemDto> fetch();
}

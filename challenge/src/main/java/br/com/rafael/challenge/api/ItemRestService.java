package br.com.rafael.challenge.api;

import br.com.rafael.challenge.model.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static br.com.rafael.challenge.constants.ItemConstants.ITEM_ENDPOINT;
import static br.com.rafael.challenge.constants.ItemConstants.REQUIRED_PARAMS;
import static br.com.rafael.challenge.util.ParseDateUtil.parseDateFromRequest;
import static java.util.stream.Collectors.toList;

@RestController
@Api(value = "item", description = "Filter avaliable items between two dates")
@RequestMapping("challenge-backend")
public class ItemRestService {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation("Return items between dates in \"dd-MM-yyyy\" format")
    @GetMapping("item")
    public ResponseEntity<List<Item>> getItems(@RequestParam(value = "begindate", required = false) String beginDate, @RequestParam(value = "finaldate", required = false) String finalDate)
            throws DateTimeParseException, IllegalArgumentException {

        if (beginDate == null || finalDate == null)
            throw new IllegalArgumentException(REQUIRED_PARAMS);

        LocalDateTime startDate = parseDateFromRequest(beginDate, LocalTime.MIN);
        LocalDateTime endDate = parseDateFromRequest(finalDate, LocalTime.MAX);

        ResponseEntity<List<Item>> exchange = restTemplate.exchange(ITEM_ENDPOINT, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Item>>(){});

        List<Item> itemList = exchange.getBody().stream()
                .filter(item -> item.getDate().isAfter(startDate) && item.getDate().isBefore(endDate)).collect(toList());

        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

}

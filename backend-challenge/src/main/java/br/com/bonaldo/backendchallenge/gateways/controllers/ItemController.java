package br.com.bonaldo.backendchallenge.gateways.controllers;

import br.com.bonaldo.backendchallenge.gateways.controllers.json.ItemResponse;
import br.com.bonaldo.backendchallenge.usecases.FilterOrderItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final FilterOrderItems filterOrderItems;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemResponse> findItems(
            @RequestParam(value = "begindate") final String beginDate,
            @RequestParam(value = "finaldate") final String finalDate) {

        log.info("Searching for items with date between {} and {}", beginDate, finalDate);

        LocalDate startDate = parseStringDate(beginDate);
        LocalDate endDate = parseStringDate(finalDate);

        return filterOrderItems.execute(startDate, endDate)
                .stream()
                .map(ItemResponse::new)
                .collect(Collectors.toList());
    }

    private LocalDate parseStringDate(final String stringDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.from(dtf.parse(stringDate));
    }
}
package com.italomlaino.backendchallenge.service;

import com.italomlaino.backendchallenge.dto.ItemDto;
import com.italomlaino.backendchallenge.exception.InvalidDateRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final MockyClient mockyClient;

    @Autowired
    public ItemServiceImpl(MockyClient mockyClient) {
        this.mockyClient = mockyClient;
    }

    @Override
    public List<ItemDto> fetch(
            LocalDate beginDate,
            LocalDate finalDate) {

        if (isInvalidDateRange(beginDate, finalDate))
            throw new InvalidDateRangeException();

        return mockyClient
                .fetch()
                .stream()
                .filter(isDateBetween(beginDate, finalDate))
                .collect(Collectors.toList());
    }

    private boolean isInvalidDateRange(LocalDate beginDate, LocalDate finalDate) {
        return beginDate != null &&
                finalDate != null &&
                beginDate.isAfter(finalDate);
    }

    private Predicate<ItemDto> isDateBetween(LocalDate beginDate, LocalDate finalDate) {
        return item -> {
            var date = item.getDate();
            if (date == null)
                return beginDate == null && finalDate == null;

            var inputDateZone = ZoneId.systemDefault().normalized();
            var convertedDate = date.withZoneSameInstant(inputDateZone).toLocalDateTime();
            var isDateAfter = beginDate == null || convertedDate.isAfter(beginDate.atStartOfDay());
            var isDateBefore = finalDate == null || convertedDate.isBefore(finalDate.atTime(LocalTime.MAX));
            return isDateAfter && isDateBefore;
        };
    }
}

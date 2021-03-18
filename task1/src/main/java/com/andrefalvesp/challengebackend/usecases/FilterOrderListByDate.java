package com.andrefalvesp.challengebackend.usecases;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

import com.andrefalvesp.challengebackend.domains.Order;
import com.andrefalvesp.challengebackend.exception.InvalidDateRangeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FilterOrderListByDate {

  public List<Order> execute(final List<Order> orderList, final LocalDate beginDate,
      final LocalDate finalDate) {
    return ofNullable(orderList)
        .orElse(emptyList())
        .stream()
        .filter(order -> isDateTimeBetweenRangeInclusive(
            Objects.requireNonNullElse(order.getDate(), LocalDate.MIN),
            beginDate,
            finalDate)
        )
        .collect(Collectors.toList());
  }

  private boolean isDateTimeBetweenRangeInclusive(final LocalDate date, final LocalDate beginDate,
      final LocalDate finalDate) {

    validDateRange(beginDate, finalDate);
    return !date.isBefore(beginDate) && !date.isAfter(finalDate);
  }

  private void validDateRange(final LocalDate beginDate, final LocalDate finalDate) {
    if (finalDate.isBefore(beginDate)) {
      throw new InvalidDateRangeException(beginDate, finalDate);
    }
  }
}
package com.herokuapp.zeversion.task1.service;

import com.herokuapp.zeversion.task1.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeBackendService {

    private final OrderClient orderClient;

    @Autowired
    public ChallengeBackendService(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public List<?> getItens(LocalDate begindate, LocalDate finaldate) {
        return this.orderClient.getItens().stream()
                .filter(item -> isBetween(begindate, finaldate, item.getDate().toLocalDate()))
                .collect(Collectors.toList());
    }

    private boolean isBetween(LocalDate begindate, LocalDate finaldate, LocalDate date) {
        return date.isAfter(begindate.minusDays(1)) && date.isBefore(finaldate.plusDays(1));
    }
}

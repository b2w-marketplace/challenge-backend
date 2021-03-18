package com.andrefalvesp.challengebackend.gateways;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderClientFallback implements FallbackFactory<OrderClient> {

  @Override
  public OrderClient create(final Throwable throwable) {
    return () -> {
      log.warn("Integration error with {} API.", "Order", throwable);
      return Collections.emptyList();
    };
  }
}
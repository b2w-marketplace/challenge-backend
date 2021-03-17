package com.italomlaino.backendchallenge.service;

import com.italomlaino.backendchallenge.dto.ItemDto;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {

    List<ItemDto> fetch(
            LocalDate beginDate,
            LocalDate finalDate);
}

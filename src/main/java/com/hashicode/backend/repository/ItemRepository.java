package com.hashicode.backend.repository;

import com.hashicode.backend.model.Item;

import java.util.List;

/**
 * Interface para o repositório de {@link Item}.
 *
 *
 * @author takahashi
 */
public interface ItemRepository {

    List<Item> getItens();
}

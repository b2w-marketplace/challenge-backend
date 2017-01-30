package br.com.munieri.domain.item.service;

import br.com.munieri.domain.item.Item;

import java.util.Date;
import java.util.List;

public interface ItemService {

    List<Item> findByInterval(Date begindate, Date finalDate);
}

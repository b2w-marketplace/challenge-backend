package br.com.munieri.infrastructure.repository.item;

import br.com.munieri.domain.item.Item;

import java.util.Date;
import java.util.List;

public interface ItemRepositoryCuston {

    List<Item> findByInterval(Date beginDate, Date finalDate);
}

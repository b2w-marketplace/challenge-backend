package br.com.munieri.domain.item.service;

import br.com.munieri.domain.item.Item;
import br.com.munieri.domain.item.ItemNotFound;
import br.com.munieri.infrastructure.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findByInterval(Date begindate, Date finalDate) {

        List<Item> items = repository.findByInterval(begindate, finalDate);
        if(items.isEmpty()) {
            throw new ItemNotFound();
        }

        return items;
    }
}

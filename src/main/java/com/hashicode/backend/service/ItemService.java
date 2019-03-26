package com.hashicode.backend.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.hashicode.backend.model.Item;
import com.hashicode.backend.repository.ItemRepository;
import com.hashicode.backend.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 *
 * Service de itens
 *
 * @author takahashi
 */
@Service
public class ItemService {

    private ItemRepository itemRepository;

    /**
     *
     * @param start
     * @param end
     * @return uma lista não vazia com os itens entre start e end
     */
    public List<Item> getItensBetween(LocalDate start, LocalDate end){
        Preconditions.checkArgument(!start.isAfter(end));
        List<Item> itens = this.itemRepository.getItens();
        if(itens!=null){
            List<Item> result = Lists.newArrayList();
            for(Item item : itens){
                LocalDate itemDate = DateUtils.toLocalDate(item.getDate());
                if(start.isEqual(itemDate) || end.isEqual(itemDate) ||
                        (itemDate.isAfter(start) && itemDate.isBefore(end)) ){
                    result.add(item);
                }
            }
            return result;
        }
        return Collections.emptyList();
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}

package br.com.himewen.task1.repository;

import br.com.himewen.task1.models.Item;
import java.util.Date;
import java.util.List;

/**
 * An interface for item repositories
 */
public interface IItemRepository {
    List<Item> getItens();
    List<Item> findByCode(String code);
    List<Item> findByName(String name);
    List<Item> findByDate(Date beginDate, Date finalDate);
}
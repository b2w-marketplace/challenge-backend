package br.com.himewen.task1.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import br.com.himewen.task1.models.Item;

/**
 * A Item repository implementing IItemRepository
 * Here you'll find search functions for itens
 */
public class ItemRepository implements IItemRepository {

    private List<Item> itens;

    public ItemRepository(List<Item> itens) {
        this.itens = itens;
    }


    /**
     * Find itens by code
     * @param code The code
     * @return A Item list with the same code
     */
    @Override
    public List<Item> findByCode(String code) {
        List<Item> itensWithCode = new ArrayList<>();
        for (Item item : itens) {
            if (item.getCode().equals(code))
                itensWithCode.add(item);
        }
        return itensWithCode;
    }

    /**
     * Find itens by name
     * @param name The item name
     * @return A Item list which the name contain the param name
     */
    @Override
    public List<Item> findByName(String name) {
        List<Item> itensWithName = new ArrayList<>();
        for (Item item : itens) {
            if (item.getName().toLowerCase().contains(name.toLowerCase()))
                itensWithName.add(item);
        }
        return itensWithName;
    }

    /**
     * Find itens by date
     * @param beginDate begin date
     * @param finalDate final date
     * @return A list of itens
     */
    @Override
    public List<Item> findByDate(Date beginDate, Date finalDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        List<Item> itensBetweenDates = new ArrayList<>();
        for (Item item : itens) {
            try {
                Date date = format.parse(item.getDate());
                if (date.after(beginDate) && date.before(finalDate)) {
                    itensBetweenDates.add(item);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return itensBetweenDates;
    }
    

    /**
     * @return List<Item> return the itens
     */
    public List<Item> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
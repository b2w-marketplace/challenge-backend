package br.com.munieri.infrastructure.repository.item;

import br.com.munieri.domain.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepositoryCuston {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<Item> findByInterval(Date beginDate, Date finalDate) {

        List resultList = em.createQuery("Select i from ItemEntity i where i.date between :beginDate and :finalDate")
                .setParameter("beginDate", beginDate)
                .setParameter("finalDate", finalDate)
                .getResultList();


        return resultList;
    }
}

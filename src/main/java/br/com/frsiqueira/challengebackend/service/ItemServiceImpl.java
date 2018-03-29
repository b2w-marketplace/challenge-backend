package br.com.frsiqueira.challengebackend.service;

import br.com.frsiqueira.challengebackend.dto.Item;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Override
    public List<Item> getItens(Calendar beginDate, Calendar finalDate) {
        return null;
    }

}

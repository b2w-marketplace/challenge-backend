package br.com.frsiqueira.challengebackend.service;

import br.com.frsiqueira.challengebackend.dto.Item;

import java.util.Calendar;
import java.util.List;

public interface ItemService {

    public List<Item> getItens(Calendar beginDate, Calendar finalDate);

}


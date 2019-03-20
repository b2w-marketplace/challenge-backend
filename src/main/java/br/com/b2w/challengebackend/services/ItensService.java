package br.com.b2w.challengebackend.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.b2w.challengebackend.dto.Item;
import br.com.b2w.challengebackend.exception.FalhaConsultaItemException;
import br.com.b2w.challengebackend.exception.ItemNaoEncotradoException;

/**
 * Created by anderson on 03/11/16.
 */

public interface ItensService {
    List<Item> consultarItemProduto(LocalDateTime inicio, LocalDateTime fim) throws ItemNaoEncotradoException, FalhaConsultaItemException;
}


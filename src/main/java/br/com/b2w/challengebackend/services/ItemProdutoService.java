package br.com.b2w.challengebackend.services;

import java.time.LocalDateTime;
import java.util.List;

import br.com.b2w.challengebackend.dto.Item;

/**
 * Created by anderson on 03/11/16.
 */

public interface ItemProdutoService {
    List<Item> consultarItemProduto(LocalDateTime var1, LocalDateTime var2);
}


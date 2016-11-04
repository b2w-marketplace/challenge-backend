package br.com.b2w.challengebackend.factory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.b2w.challengebackend.dto.Dimensao;
import br.com.b2w.challengebackend.dto.Item;

/**
 * Created by anderson on 03/11/16.
 */
public class TestFactory {

    public static List<Item> criarListaItem() {
        ArrayList itens = new ArrayList();

        LocalDateTime data = LocalDateTime.of(2016, 10, 1, 14, 30, 37, 40);

        Dimensao dimensao = new Dimensao();
        dimensao.setAltura(Double.valueOf(10.5D));
        dimensao.setComprimento(Double.valueOf(10.5D));
        dimensao.setLargura(Double.valueOf(10.5D));
        dimensao.setPeso(Double.valueOf(10.5D));

        Item item = new Item();
        item.setNome("Celular");
        item.setCodigo(Long.valueOf(1L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens.add(item);

        item = new Item();
        item.setNome("Xbox");
        item.setCodigo(Long.valueOf(2L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens.add(item);

        return itens;
    }

    public static ResponseEntity<Item[]> criarRetornoMockArrayItem() {
        Item[] itens = new Item[3];

        LocalDateTime data = LocalDateTime.of(2016, 10, 1, 14, 30, 37, 40);
        LocalDateTime dataAntiga = LocalDateTime.of(2016, 9, 23, 14, 30, 37, 40);

        Dimensao dimensao = new Dimensao();
        dimensao.setAltura(Double.valueOf(10.5D));
        dimensao.setComprimento(Double.valueOf(10.5D));
        dimensao.setLargura(Double.valueOf(10.5D));
        dimensao.setPeso(Double.valueOf(10.5D));

        Item item = new Item();
        item.setNome("Celular");
        item.setCodigo(Long.valueOf(1L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens[0] = item;

        item = new Item();
        item.setNome("Xbox");
        item.setCodigo(Long.valueOf(2L));
        item.setData(data);
        item.setDimensao(dimensao);
        itens[1] = item;

        item = new Item();
        item.setNome("Televisao");
        item.setCodigo(Long.valueOf(3L));
        item.setData(dataAntiga);
        item.setDimensao(dimensao);
        itens[2] = item;

        return new ResponseEntity(itens, HttpStatus.OK);
    }
}

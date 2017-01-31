/**
 * Projeto Challenge Backend
 *
 * @author <a href="mailto:leandrorcom@gmail.com">Leandro Rodrigues Combinato</a>
 */
package com.sistema.mvc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.sistema.mvc.entity.Produto;

/*
 * Classe que Controla os Produtos  
 */
@RestController("/item")
@RequestMapping("/")
public class ProdutoController {
	
	private static final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
	
	
	/**
	 * Metodo responsavel por chamar o serviço da API e popular uma Lista de Produtos
	 * @return List<Produto>
	 */
	private List<Produto> callServiceJson() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			RestTemplate template = new RestTemplate();
			ResponseEntity<Produto[]> resp = template.getForEntity(URL, Produto[].class);
			produtos = Arrays.asList(resp.getBody());
		} catch(HttpServerErrorException ex) {
			produtos = new ArrayList<Produto>();
		}
		return produtos;
	}
	
	
	/**
	 * Metodo responsavel por listar todos os produtos por data inicio e data final
	 * @return ResponseEntity<List<Produto>>
	 */

	@RequestMapping(value = "/{begindate}/{finaldate}", method = RequestMethod.GET, produces = { "application/json"})
	public ResponseEntity<List<Produto>> listaProdutos(@RequestParam(value = "begindate") @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDate pBeginDate,
			@RequestParam(value = "finaldate") @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDate pFinalDate, Model model) {
		
		List<Produto> listaProdutos = callServiceJson();
		if (listaProdutos != null) {
			
			if(listaProdutos.size() > 0) {
				listaProdutos = listaProdutos.stream().
						filter(x -> (((Produto) x).getDate().isAfter(pBeginDate) || ((Produto) x).getDate().isEqual(pBeginDate))
								&& (((Produto) x).getDate().isBefore(pFinalDate) || ((Produto) x).getDate().isEqual(pFinalDate))).
						collect(Collectors.toList());
			}
			model.addAttribute("produtos", listaProdutos);
		}
		return new ResponseEntity<List<Produto>>(listaProdutos, HttpStatus.OK);
	}

}
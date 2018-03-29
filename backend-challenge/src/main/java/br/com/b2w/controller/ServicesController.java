package br.com.b2w.controller;

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

import br.com.b2w.entity.ProductEntity;

/**
 * Classe de controle dos serviços
 * 
 * @author Rafael Felix de Moraes
 *
 */

@RestController("/item")
@RequestMapping("/")
public class ServicesController {

	// Endereço da API a ser consumida pelos serviços
	private static final String URL = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";
		
		
		/**
		 * Metodo responsavel por chamar o serviço da API e popular uma lista de Produtos
		 * 
		 * @return List<Produto> A lista de produtos populada
		 */
		private List<ProductEntity> callServiceJson() {
			List<ProductEntity> produtos = new ArrayList<ProductEntity>();
			try {
				RestTemplate template = new RestTemplate();
				ResponseEntity<ProductEntity[]> resp = template.getForEntity(URL, ProductEntity[].class);
				produtos = Arrays.asList(resp.getBody());
			} catch(HttpServerErrorException ex) {
				produtos = new ArrayList<ProductEntity>();
			}
			return produtos;
		}
		
		
		/**
		 * Metodo responsavel por listar todos os produtos filtrando por data inicio e data final
		 * 
		 * @return ResponseEntity<List<Produto>> A entidade de resposta contendo o json com os produtos listados conforme filtro definido
		 */
	
		@RequestMapping(value = "/{begindate}/{finaldate}", method = RequestMethod.GET, produces = { "application/json"})
		public ResponseEntity<List<ProductEntity>> listaProdutos(@RequestParam(value = "begindate") @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDate pBeginDate,
				@RequestParam(value = "finaldate") @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDate pFinalDate, Model model) {
			
			List<ProductEntity> listaProdutos = callServiceJson();
			if (listaProdutos != null) {
				
				if(listaProdutos.size() > 0) {
					listaProdutos = listaProdutos.stream().
							filter(x -> (((ProductEntity) x).getDate().isAfter(pBeginDate) || ((ProductEntity) x).getDate().isEqual(pBeginDate))
									&& (((ProductEntity) x).getDate().isBefore(pFinalDate) || ((ProductEntity) x).getDate().isEqual(pFinalDate))).
							collect(Collectors.toList());
				}
				model.addAttribute("produtos", listaProdutos);
			}
			return new ResponseEntity<List<ProductEntity>>(listaProdutos, HttpStatus.OK);
		}
}

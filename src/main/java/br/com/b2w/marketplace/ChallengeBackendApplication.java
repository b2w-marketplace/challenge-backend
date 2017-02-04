package br.com.b2w.marketplace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ObjectUtils;

import br.com.b2w.marketplace.component.ItemFilterComponent;
import br.com.b2w.marketplace.response.Item;
import br.com.b2w.marketplace.response.ItemList;
import br.com.b2w.marketplace.service.MockyAPIService;

@SpringBootApplication
public class ChallengeBackendApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeBackendApplication.class);	
	
	private static boolean executarEndpoint = false;
	
	private static final String BEGIN_DATE_PARAM = "05-10-2016";
	
	private static final String FINAL_DATE_PARAM = "10-10-2016";
	
	private static String ENDPOINT = "http://localhost:8080/challenge-backend/item?begindate="
			.concat(BEGIN_DATE_PARAM).concat("&finaldate=").concat(FINAL_DATE_PARAM);
	
	public static void main(String[] args) {
		
		if (!ObjectUtils.isEmpty(args)
				&& args.length > 0) {
			
			String param = args[0];
			
			try {
				
				executarEndpoint = Boolean.valueOf(param.toLowerCase());
				
			} catch (Exception ex) {
				LOGGER.error("ERRO ao converter valor parametro: " 
						+ ex.getMessage(), ex);
			}
			
		}
		
		SpringApplication.run(ChallengeBackendApplication.class, args);

	}
	
	@Bean
	protected CommandLineRunner commandLineRunner(final MockyAPIService mockyAPIService, 
			final ItemFilterComponent itemFilterComponent) {
		
		if (executarEndpoint) {
			
			return new CommandLineRunner() {

				@Override
				public void run(String... arg0) throws Exception {
			
					try {
											
						ItemList itemList = mockyAPIService.recuperarItens(ENDPOINT);
						
						itemList = itemFilterComponent.filtrarRegistros(BEGIN_DATE_PARAM, FINAL_DATE_PARAM, itemList.list());
						
						LOGGER.info("\n\n");
						LOGGER.info("\tRESULTADO");
						
						for (Item item : itemList.list()) {
							LOGGER.info("\n### " + item);
						}
						
						LOGGER.info("\n\n");
						
					} catch (Exception ex) {
						LOGGER.error("ERRO ao invocar API:" 
								+ ex.getMessage(), ex);
					}
					
				}
			};
			
		}
		
		return null;
		
	}

	
}

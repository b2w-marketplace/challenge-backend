package br.com.challengebackend.challengebackend.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.challengebackend.challengebackend.controller.dto.ItensDto;
import br.com.challengebackend.challengebackend.modelo.Dimension;
import br.com.challengebackend.challengebackend.modelo.Itens;
import br.com.challengebackend.challengebackend.repository.ItensRepository;

@RestController
public class ItensController {
	
	@Autowired
	private ItensRepository itensRepository;
	
	@RequestMapping("/challenge-backend/item")
	public List<ItensDto> lista() {
		List<Itens> itens = itensRepository.findAll();
	    return ItensDto.converter(itens);
	}

}

package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@RestController
@RequestMapping("/forma-pagamento")
public class FormaPagamentoController {
	
	@Autowired
	private FormaPagamentoRepository repository;
	
	@GetMapping
	public List<FormaPagamento> listar(){
		return repository.findAll();
	}

}

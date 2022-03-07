package com.algaworks.algafood.api.controller;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.service.CadastroPermissaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("permissoes")
public class PermissaoController {

	@Autowired
	private CadastroPermissaoService permissaoService;
	
	@GetMapping
	public List<Permissao> listar(){
		return permissaoService.findAll();
	}
	
}

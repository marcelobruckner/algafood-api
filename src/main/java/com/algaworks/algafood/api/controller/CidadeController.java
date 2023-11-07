package com.algaworks.algafood.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.algaworks.algafood.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	private CadastroCidadeService cadastroCidade;

	public CidadeController(CadastroCidadeService cadastroCidade) {
		this.cadastroCidade = cadastroCidade;
	}

	@GetMapping
	public List<Cidade> listar() {
		return cadastroCidade.listar();
	}

	@GetMapping("/{id}")
	public Cidade buscar(@PathVariable Long id) {
		return cadastroCidade.buscarOuFalhar(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody @Valid Cidade cidade) {
		try {
			return cadastroCidade.salvar(cidade);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@PutMapping("/{id}")
	public Cidade atualizar(@PathVariable Long id, @RequestBody @Valid Cidade cidade) {
		Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(id);

		BeanUtils.copyProperties(cidade, cidadeAtual, "id");

		try {
			return cadastroCidade.salvar(cidadeAtual);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		cadastroCidade.remover(id);
	}

}

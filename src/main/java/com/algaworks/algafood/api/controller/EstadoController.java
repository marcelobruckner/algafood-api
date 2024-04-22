package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.assembler.EstadoInputDisassembler;
import com.algaworks.algafood.api.assembler.EstadoModelAssembler;
import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.api.model.input.EstadoInput;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoModelAssembler estadoModelAssembler;

	@Autowired
	private EstadoInputDisassembler estadoInputDisassembler;

	private CadastroEstadoService cadastroEstado;

	public EstadoController(CadastroEstadoService cadastroEstado) {
		this.cadastroEstado = cadastroEstado;
	}

	@GetMapping
	public List<EstadoModel> listar() {
		List<Estado> todosEstados = cadastroEstado.listar();
		return estadoModelAssembler.toCollectionModel(todosEstados);
	}

	@GetMapping("/{id}")
	public EstadoModel buscar(@PathVariable Long id) {
		Estado estado = cadastroEstado.buscarOuFalhar(id);
		return estadoModelAssembler.toModel(estado);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoModel adicionar(@RequestBody @Valid EstadoInput estadoInput) {
		Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
		estado = cadastroEstado.salvar(estado);
		return estadoModelAssembler.toModel(estado);
	}

	@PutMapping("/{id}")
	public EstadoModel atualizar(@PathVariable Long id, @RequestBody @Valid EstadoInput estadoInput) {

		Estado estadoAtual = cadastroEstado.buscarOuFalhar(id);
		estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);
		estadoAtual = cadastroEstado.salvar(estadoAtual);

		return estadoModelAssembler.toModel(estadoAtual);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		cadastroEstado.remover(id);
	}
}

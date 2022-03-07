package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroFormaPagamentoService {

  @Autowired
  private FormaPagamentoRepository repository;

  public List<FormaPagamento> findAll() {
    return repository.findAll();
  }

}

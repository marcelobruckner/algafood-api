package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroCozinhaIntegrationTests {

  @Autowired
  private CadastroCozinhaService cozinhaService;

  @Test
  public void testarCadastroCozinhaComSucesso() {
    Cozinha novaCozinha = new Cozinha();
    novaCozinha.setNome("Chinesa");

    novaCozinha = cozinhaService.salvar(novaCozinha);

    assertThat(novaCozinha).isNotNull();
    assertThat(novaCozinha.getId()).isNotNull();
  }

  @Test(expected = ConstraintViolationException.class)
  public void testarCadastroCozinhaSemNome() {
    Cozinha novaCozinha = new Cozinha();
    novaCozinha.setNome(null);

    novaCozinha = cozinhaService.salvar(novaCozinha);
  }
}

package com.algaworks.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryCustom;

import org.springframework.stereotype.Repository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
    System.out.println("RestauranteRepositoryImpl ::: find");
		System.out.println("nome: " + nome);
		System.out.println("taxaInicial: " + taxaFreteInicial);
		System.out.println("taxaFinal: " + taxaFreteFinal);

    var jpql = "from Restaurante where nome like :nome "
             + "and taxaFrete between :taxaInicial and :taxaFinal";

    return manager.createQuery(jpql, Restaurante.class)
                  .setParameter("nome", "%" + nome + "%")
                  .setParameter("taxaInicial", taxaFreteInicial)
                  .setParameter("taxaFinal", taxaFreteFinal)
                  .getResultList();
  }
}

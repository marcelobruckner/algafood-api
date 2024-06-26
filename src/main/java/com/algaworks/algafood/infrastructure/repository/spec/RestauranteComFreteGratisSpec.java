package com.algaworks.algafood.infrastructure.repository.spec;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.algaworks.algafood.domain.model.Restaurante;

import org.springframework.data.jpa.domain.Specification;

public class RestauranteComFreteGratisSpec implements Specification<Restaurante> {

  private static final long serialVersionUID = 1L;

  @SuppressWarnings("null")
  @Override
  public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    return builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
  }

  
  
}

package com.algaworks.algafood.infrastructure.repository.spec;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.algafood.domain.model.Restaurante;

public class RestauranteSpecs {

	public static Specification<Restaurante> comFreteGratis(){
		return (root, query, builder) -> 
			builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
	}
	
	public static Specification<Restaurante> comNomeSemelhante(String nome){
		return (root, query, builder) ->
			builder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Restaurante> comFreteAcimaDeDoisReais(){
		return new Specification<Restaurante>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.greaterThan(root.get("taxaFrete"), BigDecimal.valueOf(2.0));
			}
		};
	}
}

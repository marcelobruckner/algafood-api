package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
		extends JpaRepository<Restaurante, Long>, RestauranteRepositoryCustom, JpaSpecificationExecutor<Restaurante> {

	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

	// @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinhaId);
	// List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long
	// cozinhaId);

	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

	List<Restaurante> findTop2RestaurantesByNomeContaining(String nome);

	int countByCozinhaId(Long cozinhaId);

}

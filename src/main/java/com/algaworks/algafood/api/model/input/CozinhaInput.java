package com.algaworks.algafood.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CozinhaInput {

    @NotBlank
    private String nome;

}

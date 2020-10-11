package com.marcos.padilha.pagarContas.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Conta {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("valorOriginal")
    private Double valorOriginal;
    @JsonProperty("dataPagamento")
    private String dataPagamento;
    @JsonProperty("dataVencimento")
    private String dataVencimento;
}

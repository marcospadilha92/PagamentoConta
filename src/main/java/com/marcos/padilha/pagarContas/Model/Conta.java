package com.marcos.padilha.pagarContas.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Conta {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("valorOriginal")
    private Double valorOriginal;
    @JsonProperty("dataPagamento")
    private LocalDate dataPagamento;
    @JsonProperty("dataVencimento")
    private LocalDate dataVencimento;
}

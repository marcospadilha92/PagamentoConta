package com.marcos.padilha.pagarContas.MySql.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "contas", schema = "pagamento")
public class ContaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INT_ID")
    private int int_id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VALOR_ORIGINAL")
    private Double valorOriginal;

    @Column(name = "VALOR_CORRIGIDO")
    private Double valorCorrigido;

    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dataPagamento;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDate dataVencimento;

    @Column(name = "DIAS_ATRASO")
    private int diasAtraso;
}

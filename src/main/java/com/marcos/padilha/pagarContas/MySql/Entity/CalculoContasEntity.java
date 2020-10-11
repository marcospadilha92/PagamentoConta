package com.marcos.padilha.pagarContas.MySql.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "CALCULO_CONTAS", schema = "PAGAMENTO")
public class CalculoContasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DIAS_ATRASO")
    private String diasAtraso;

    @Column(name = "MULTA_PORCENTAGEM")
    private int multaPorcentagem;

    @Column(name = "JUROS_DIA")
    private Double jurosDia;
}

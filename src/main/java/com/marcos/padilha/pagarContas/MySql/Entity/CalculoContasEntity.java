package com.marcos.padilha.pagarContas.MySql.Entity;

import javax.persistence.*;

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

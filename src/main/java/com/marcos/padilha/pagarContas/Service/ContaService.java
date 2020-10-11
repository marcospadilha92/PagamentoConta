package com.marcos.padilha.pagarContas.Service;

import com.marcos.padilha.pagarContas.MySql.Entity.CalculoContasEntity;
import com.marcos.padilha.pagarContas.MySql.Entity.ContaEntity;
import com.marcos.padilha.pagarContas.MySql.Repository.CalculoContasRepository;
import com.marcos.padilha.pagarContas.MySql.Repository.ContaRepository;
import com.marcos.padilha.pagarContas.Model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    CalculoContasRepository calculoContasRepository;

    public void inserirConta(Conta conta){
        Double valorCorrigido = calculaTaxaAtraso(conta);

        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setNome(conta.getNome());
        contaEntity.setValorOriginal(conta.getValorOriginal());
        contaEntity.setDataPagamento(conta.getDataPagamento());
        contaEntity.setDataVencimento(conta.getDataPagamento());
        contaRepository.save(contaEntity);
    }

    public Double calculaTaxaAtraso(Conta conta){
        CalculoContasEntity calculoContasEntity = new CalculoContasEntity();
        long elapsedDays = ChronoUnit.DAYS.between(conta.getDataVencimento(), conta.getDataPagamento());
        String diasAtraso = "";

        if(elapsedDays == 0 ){
            return 0.0;
        }
        if(elapsedDays <= 3){
            diasAtraso = "";
        } else if (elapsedDays <= 5){
            diasAtraso = "";
        } else {
            diasAtraso = "";
        }
        calculoContasRepository.findByDiasAtraso(diasAtraso);

    }
}

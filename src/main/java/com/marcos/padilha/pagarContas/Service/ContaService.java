package com.marcos.padilha.pagarContas.Service;

import com.marcos.padilha.pagarContas.MySql.Entity.CalculoContasEntity;
import com.marcos.padilha.pagarContas.MySql.Entity.ContaEntity;
import com.marcos.padilha.pagarContas.MySql.Repository.CalculoContasRepository;
import com.marcos.padilha.pagarContas.MySql.Repository.ContaRepository;
import com.marcos.padilha.pagarContas.Model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ContaService {

    private static final String ATETRESDIAS = "Ate 3 dias";
    private static final String SUPERIORTRESDIAS = "superior a 3 dias";
    private static final String SUPERIORCINCODIAS = "superior a 5 dias";

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    CalculoContasRepository calculoContasRepository;

    public void inserirConta(Conta conta){
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataVencimento = LocalDate.parse(conta.getDataVencimento(), dataFormatada);
        LocalDate dataPagamento = LocalDate.parse(conta.getDataPagamento(), dataFormatada);
        int diasPassados = (int) ChronoUnit.DAYS.between(dataVencimento, dataPagamento);

        Double valorCorrigido = calculaTaxaAtraso(diasPassados, conta.getValorOriginal());

        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setNome(conta.getNome());
        contaEntity.setValorOriginal(conta.getValorOriginal());
        contaEntity.setValorCorrigido(valorCorrigido);
        contaEntity.setDataPagamento(dataPagamento);
        contaEntity.setDataVencimento(dataVencimento);
        contaEntity.setDiasAtraso(diasPassados);
        contaRepository.save(contaEntity);
    }

    public List<ContaEntity> listarContas(){
        return contaRepository.listarContas();
    }

    public Double calculaTaxaAtraso(int diasPassados, Double valorOriginal){

        String diasAtraso = "";

        if(diasPassados == 0 || diasPassados < 0){
            return valorOriginal;
        }
        if(diasPassados <= 3){
            diasAtraso = ATETRESDIAS;
        } else if (diasPassados <= 5){
            diasAtraso = SUPERIORTRESDIAS;
        } else {
            diasAtraso = SUPERIORCINCODIAS;
        }
        CalculoContasEntity calculoContasEntity = calculoContasRepository.findByDiasAtraso(diasAtraso);
        Double valorCorrigido =  valorOriginal;
        valorCorrigido += ((valorOriginal * (calculoContasEntity.getJurosDia() * diasPassados)) / 100);
        valorCorrigido += ((valorOriginal * calculoContasEntity.getMultaPorcentagem()) / 100);

        return valorCorrigido;
    }
}

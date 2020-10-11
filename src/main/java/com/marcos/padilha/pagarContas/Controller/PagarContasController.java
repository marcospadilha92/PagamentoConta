package com.marcos.padilha.pagarContas.Controller;

import com.marcos.padilha.pagarContas.Model.Conta;
import com.marcos.padilha.pagarContas.Service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contas")
public class PagarContasController {

    @Autowired
    ContaService contaService;

    @GetMapping("/listar")
    public List<Conta> listarContas(){
        List<Conta> listaContas = new ArrayList<>();

        return listaContas;
    }

    @PostMapping("/inserir")
    public void inserirConta(@RequestBody Conta conta){
        contaService.inserirConta(conta);
    }
}

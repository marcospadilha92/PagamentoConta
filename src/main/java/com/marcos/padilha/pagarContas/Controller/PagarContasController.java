package com.marcos.padilha.pagarContas.Controller;

import com.marcos.padilha.pagarContas.Model.Conta;
import com.marcos.padilha.pagarContas.MySql.Entity.ContaEntity;
import com.marcos.padilha.pagarContas.Service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contas")
public class PagarContasController {

    @Autowired
    ContaService contaService;

    @GetMapping("/listar")
    public ResponseEntity<List<ContaEntity>> listarContas(){
        return ResponseEntity.ok().body(contaService.listarContas());
    }

    @PostMapping("/inserir")
    public ResponseEntity<String> inserirConta(@RequestBody Conta conta){
        contaService.inserirConta(conta);
        return ResponseEntity.ok("inserido com sucesso");
    }
}

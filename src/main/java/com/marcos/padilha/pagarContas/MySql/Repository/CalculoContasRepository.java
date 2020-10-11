package com.marcos.padilha.pagarContas.MySql.Repository;

import com.marcos.padilha.pagarContas.MySql.Entity.CalculoContasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoContasRepository extends JpaRepository<CalculoContasEntity, Integer> {

//    @Query(value = "SELECT MULTA_PORCENTAGEM, JUROS_DIAS FROM ", nativeQuery = true)
//    CalculoContasEntity buscaCalculo();
    CalculoContasEntity findByDiasAtraso(String diasAtraso);
}

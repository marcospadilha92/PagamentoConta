package com.marcos.padilha.pagarContas.MySql.Repository;

import com.marcos.padilha.pagarContas.MySql.Entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Integer> {
    @Query(value = "SELECT * FROM CONTAS", nativeQuery = true)
    List<ContaEntity> listarContas();
}

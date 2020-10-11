package com.marcos.padilha.pagarContas.MySql.Repository;

import com.marcos.padilha.pagarContas.MySql.Entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Integer> {
}

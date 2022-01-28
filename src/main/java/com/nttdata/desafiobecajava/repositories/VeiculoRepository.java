package com.nttdata.desafiobecajava.repositories;

import com.nttdata.desafiobecajava.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  VeiculoRepository extends JpaRepository<Veiculo,Long> {
}

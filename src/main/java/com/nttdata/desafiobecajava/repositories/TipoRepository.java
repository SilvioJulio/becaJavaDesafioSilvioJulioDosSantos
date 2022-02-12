package com.nttdata.desafiobecajava.repositories;

import com.nttdata.desafiobecajava.domains.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository  extends JpaRepository<Tipo,Long> { }

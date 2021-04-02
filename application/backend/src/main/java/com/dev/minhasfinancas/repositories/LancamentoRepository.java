package com.dev.minhasfinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.minhasfinancas.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}

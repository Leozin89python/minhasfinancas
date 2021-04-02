package com.dev.minhasfinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.minhasfinancas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

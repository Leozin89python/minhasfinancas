package com.dev.minhasfinancas;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dev.minhasfinancas.entities.Usuario;
import com.dev.minhasfinancas.repositories.UsuarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = new Usuario();
		usuario.setNome("usuario");
		usuario.setEmail("usuario@gmail.com");
		repository.save(usuario);
		
		//ação
		boolean result = repository.existsByEmail("usuario@gmail.com");
		
		//verificação
		Assertions.assertThat(result).isTrue();
	}
}

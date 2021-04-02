package com.dev.minhasfinancas.service;

import com.dev.minhasfinancas.entities.Usuario;

public interface UsuarioService {
	Usuario autenticar(String email, String senha);
	Usuario salvarUsuario(Usuario usuario);
	void validarEmail(String email);
}

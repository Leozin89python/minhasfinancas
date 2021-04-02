package com.dev.minhasfinancas.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.minhasfinancas.entities.Usuario;
import com.dev.minhasfinancas.exception.ErroAutenticacao;
import com.dev.minhasfinancas.exception.RegraNegocioException;
import com.dev.minhasfinancas.repositories.UsuarioRepository;
import com.dev.minhasfinancas.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{

	private UsuarioRepository repository;
   
	@Autowired
	public UsuarioServiceImp(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado!");
		}
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida!");
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("já existe há um usuário com este email!");
		}
	}
}

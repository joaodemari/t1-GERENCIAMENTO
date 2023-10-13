package service;

import bean.Usuario;

public interface UsuarioService {
	public boolean isAdministrador(Usuario usuario);
	public boolean isFuncionario(Usuario usuario);
}

package br.com.einsteinlimeira.aulaswing.model.services;

import br.com.einsteinlimeira.aulaswing.model.Usuario;
import br.com.einsteinlimeira.aulaswing.model.database.UsuarioDAO;

public class ServicoLogin {
	
	public boolean validarUsuario (String username, String senha) {
		
		// Cria o usuário com os dados passados
		Usuario usuario = new Usuario(username, senha);
		
		// Chama um objeto de acesso a dados para validar o usuário junto ao BD
		return new UsuarioDAO().validarUsuario(usuario);
	}
}

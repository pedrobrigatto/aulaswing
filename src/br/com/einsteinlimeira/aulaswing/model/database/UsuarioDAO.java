package br.com.einsteinlimeira.aulaswing.model.database;

import br.com.einsteinlimeira.aulaswing.model.Usuario;

/**
 * Classe que representa objetos de acesso a dados de usuário. Inicialmente, estamos considerando
 * que a aplicação não tem um banco de dados associado, e as informações estão todas em memória,
 * em uma lista mantida em uma classe que representa o repositório de dados. 
 * 
 * @author pedrobrigatto
 */
public class UsuarioDAO {
	
	private Repositorio repositorio;
	
	public UsuarioDAO () {
		repositorio = new Repositorio();
	}
	
	public boolean validarUsuario(Usuario usuario) {
		// Abriria uma conexão com o banco de dados para verificar se o usuário fornecido 
		// na operação de login é válido ou não no sistema. 		
		Usuario usuarioAtual = null;
		
		String usernameBanco = null;
		String usernameTela = null;
		String senhaBanco = null;
		String senhaTela = null;
		
		for (int posicao=0; posicao < repositorio.baixarTabelaUsuarios().size(); posicao++) {
			
			usuarioAtual = repositorio.baixarTabelaUsuarios().get(posicao);
			
			usernameBanco =usuarioAtual.getUsername();
			usernameTela = usuario.getUsername();
			
			senhaBanco = usuarioAtual.getSenha();
			senhaTela = usuario.getSenha();
			
			if (usernameBanco.equals(usernameTela) &&
					senhaBanco.equals(senhaTela)) {
				return true;
			}
		}
		return false;
	}
}

package br.com.einsteinlimeira.aulaswing.model.database;

import java.util.ArrayList;
import java.util.List;

import br.com.einsteinlimeira.aulaswing.model.Usuario;

/**
 * @author pedrobrigatto
 *
 */
public class Repositorio {
	
	private List<Usuario> TABELA_USUARIOS = new ArrayList<Usuario>();
	
	public Repositorio() {
		carregarTabelaUsuarios();
	}

	private void carregarTabelaUsuarios() {
		TABELA_USUARIOS.add(new Usuario("pedro", "pwdpedro"));
		TABELA_USUARIOS.add(new Usuario("joao", "pwdjoao"));
		TABELA_USUARIOS.add(new Usuario("maria", "pwdmaria"));
		TABELA_USUARIOS.add(new Usuario("paulo", "pwdpaulo"));
		TABELA_USUARIOS.add(new Usuario("carlos", "pwdcarlos"));		
	}
	
	public List<Usuario> baixarTabelaUsuarios() {
		return this.TABELA_USUARIOS;
	}
}

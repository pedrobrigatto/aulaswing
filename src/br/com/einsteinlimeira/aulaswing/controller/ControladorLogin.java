package br.com.einsteinlimeira.aulaswing.controller;

import br.com.einsteinlimeira.aulaswing.model.services.ServicoLogin;
import br.com.einsteinlimeira.aulaswing.view.TelaLogin;

/**
 * Representa o controlador de operações relacionadas a login/logoff.
 * 
 * @author pedrobrigatto
 */
public class ControladorLogin {
	
	// Atributo que guardará o único objeto ControladorLogin da aplicação
	private static ControladorLogin controlador = new ControladorLogin();
	
	private TelaLogin telaLogin;
	
	// Quando colocamos o construtor default privado, eliminamos a chance desta
	// classe ser instanciada externamente, a partir de outro ponto que não seja a
	// classe ControladorLogin.
	private ControladorLogin() {}
	
	// Uma vez que não se pode criar objetos ControladorLogin de fora desta classe, 
	// o acesso ao único objeto ControladorLogin deverá ser necessariamente estático.
	public static ControladorLogin pegarControlador() {
		return controlador;
	}
	
	// Método de instância, usado para verificar se um usuário existe no sistema.
	public boolean verificarUsuario(String username, String senha) {
		
		// Chamar um serviço de login, passando os dados do usuário  que deve ser validado
		ServicoLogin servico = new ServicoLogin();
		return servico.validarUsuario(username, senha);
	}

	/**
	 * Método que inicia a execução do sistema com a apresentação da tela de login.
	 */
	public void iniciar() {
		telaLogin = new TelaLogin();
		telaLogin.setVisible(true);
	}
}

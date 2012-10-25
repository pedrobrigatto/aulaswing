package br.com.einsteinlimeira.aulaswing.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.einsteinlimeira.aulaswing.controller.ControladorLogin;

/**
 * Tela de login.
 * 
 * @author pedrobrigatto
 */
public class TelaLogin extends JFrame implements ActionListener {
	
	/** Número serial para controlar versão da classe (utilidade em serialização e desserialização de objetos) */
	private static final long serialVersionUID = -3202720881747750437L;
	
	// Campos que serão usados para compor a tela.
	private JLabel labelUsername;
	private JLabel labelSenha;
	private JButton btnLogin;
	private JButton btnLimpar;
	private JTextField txtUsername;
	private JPasswordField pwdUsuario;
	
	// Construção da tela.
	public TelaLogin () {
		montarTela();
	}
	
	// Método privado para implementarmos a criação de todos os campos e a adição
	// desses componentes na tela.
	private void montarTela() {
		
		// Gerenciador de layout é o componente que organiza, internamente, os campos
		// da tela, de acordo com algoritmos específicos. Cada tipo de gerenciador de layout
		// tem uma lógica própria de posicionamento de componentes na tela.
		GridLayout gerenciadorLayout = new GridLayout(3, 2);
		this.setLayout(gerenciadorLayout);
		
		// Criando os componentes
		labelUsername = new JLabel("Username:");
		labelSenha = new JLabel("Senha:");
		
		txtUsername = new JTextField(10);
		pwdUsuario = new JPasswordField(10);
		
		btnLogin = new JButton("Entrar");
		btnLogin.setActionCommand("Entrar");
		btnLogin.addActionListener(this);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setActionCommand("Limpar");
		btnLimpar.addActionListener(this);
		
		// Uma vez que os componentes (campos) já foram criados, é hora de adicioná-los na tela.
		this.add(labelUsername);
		this.add(txtUsername);
		this.add(labelSenha);
		this.add(pwdUsuario);
		this.add(btnLimpar);
		this.add(btnLogin);
		
		// Existem muitas propriedades (atributos) de um frame que podem ser modificadas. 
		// Algumas delas são modificadas logo abaixo: posicionamento relativo, tamanho, visibilidade e título.
		this.setSize(220, 100);
		this.setLocationRelativeTo(null);
		this.setTitle("Tela de Login");
	}

	// Este método está declarado na interface ActionListener, e é usado para capturar os eventos gerados
	// por botões. Todo botão, quando clicado, gera eventos do tipo ActionEvent.
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// Como a tela será o objeto que receberá eventos dos dois botões (LImpar e Entrar), é necessário
		// que chequemos de onde o evento está vindo, porque a nossa ação depende de sua origem.
		// Há duas maneiras para sabermos de onde vem o evento ActionEvent. 
		
		// Abordagem 1: usamos o action command que definimos para cada botão. O Action Command é uma string
		// que representa um "carimbo" que o botão usa para "marcar" seus eventos antes de lançá-lo para seus listeners.
		if ("Entrar".equals(evento.getActionCommand())) {
			
			// Verificar se os campos estão preenchidos. Se estiverem, entramos no sistema. Senão, avisamos o usuário.
			if (camposVazios()) {
				// aviso o usuário
				JOptionPane.showMessageDialog(this, "Preencha os dados e tente novamente");
			} else {
				boolean existe = ControladorLogin.pegarControlador().
				    verificarUsuario(txtUsername.getText(), 
				    		new String(pwdUsuario.getPassword()));
				
				if (existe) {
					JOptionPane.showMessageDialog(this, "Abriria a tela home, próxima aula!!");
				} else {
					JOptionPane.showMessageDialog(this, "Usuário inválido!! ");
				}
			}
			
		} else if ("Limpar".equals(evento.getActionCommand())) {
			
			// Precisamos apenas mudar o texto dos campos para uma String vazia. 
			this.txtUsername.setText("");
			this.pwdUsuario.setText("");			
		}
		
		// Abordagem 2: usamos o evento para saber sua origem, sem precisar usar action command. 
		// Neste caso, não precisaríamos ter usado os métodos setActionCommand (String) dos botões.
		// Como o tratamento já foi feito acima, aqui é só para exemplificar a outra possibilidade mesmo,
		// a lógica não será repetida.
		if (evento.getSource() == btnLimpar) {
			
			// seria o equivalente a if ("Limpar".equals(evento.getActionCommand()
			
		} else if (evento.getSource() == btnLogin) {
			
			// seria o equivalente a "Entrar".equals(evento.getActionCommand() 
			
		}
	}
	
	private boolean camposVazios() {
		
		// inicialmente, suponho que os campos estão vazios.
		boolean camposEstaoVazios = true;
		
		String valorUsername = txtUsername.getText();
		String valorSenha = new String(pwdUsuario.getPassword());
		
		// Precisamos saber se os textos de ambos os campos não são strings vazias e não 
		// são nulos também ... se não forem, é porque há conteúdo digitado neles. 
		if (valorUsername != null && !"".equals(valorUsername)  && 
				valorSenha != null && !"".equals(valorSenha)) {
			camposEstaoVazios = false;			
		} 
		return camposEstaoVazios;
	}
}

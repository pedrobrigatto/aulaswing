package br.com.einsteinlimeira.aulaswing.controller;

/**
 * A execução de um sistema desenhado sobre o MVC inicia sempre por um controlador.
 * Este controlador principal é o ponto de partida do sistema. 
 * 
 * @author pedrobrigatto
 */
public class ControladorPrincipal {
	
	public static void main (String [] args) {
		ControladorLogin.pegarControlador().iniciar();
	}
}

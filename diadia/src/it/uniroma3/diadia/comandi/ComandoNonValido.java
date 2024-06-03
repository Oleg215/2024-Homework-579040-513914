package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	public void esegui(Partita partita) {
		System.out.println("Comando sconosciuto");
	}
	public void setParametro(String parametro) {}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}

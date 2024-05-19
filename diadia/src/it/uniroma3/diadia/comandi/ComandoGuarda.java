package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Command {
	public void esegui(Partita partita) {
		System.out.println(partita.getLabirinto().getStanzaCorrente().toString()+"\n");
		System.out.println(partita.getGiocatore().getCfu()+"\n");
		System.out.println(partita.getGiocatore().getBorsa().toString());
		
		
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

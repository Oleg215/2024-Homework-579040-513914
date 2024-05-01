package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Command {
	private String nomeAttrezzo;
	public void esegui(Partita partita) {
		Attrezzo a;
		if(nomeAttrezzo==null) {
			System.out.println("specificare oggetto che si vuole posare");
		return;}
		if(partita.getGiocatore().getBorsa().isEmpty()) {
			System.out.println("nulla da posare");
			return;}
		else if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			System.out.println("non hai questo oggetto");
			return;} 
		else if(partita.getLabirinto().getStanzaCorrente().isFull()) {
			System.out.println("stanza piena");
			return;}
		else {
			a=partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(a))
				System.out.println("Oggetto posato");	
			else 
				System.out.println("Qualcosa è andato storto");
			return;
	
	
		}}
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
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

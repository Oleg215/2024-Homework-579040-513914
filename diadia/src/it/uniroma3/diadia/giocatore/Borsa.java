package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
//	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>(); // speriamo bastino...
//		this.numeroAttrezzi = 0;
	}
//	public int getNumeroAttrezzi() {
//		return this.numeroAttrezzi;
//	}

	public List<Attrezzo> getAttrezzi() {
		return attrezzi;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (attrezzo==null)
			return false;

		this.attrezzi.add(attrezzo);
		return true;
	}
	
	

	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
		for(Attrezzo a : this.attrezzi)
			if (a!=null && a.getNome().equals(nomeAttrezzo))
				return a;
		return null;
	}
	
	public int getPeso(){
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi)
			pesoTotale += a.getPeso();
		return pesoTotale;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo==null || !this.hasAttrezzo(nomeAttrezzo))
			return null;
		else {
			for(Attrezzo attrezzo: this.attrezzi) {
				if(nomeAttrezzo!=null)
					 this.attrezzi.remove(attrezzo);
			}
		}
		return a;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}



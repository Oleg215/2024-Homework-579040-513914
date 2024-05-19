package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import java.util.HashSet;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.*;



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
		if ((this.getPeso() + attrezzo.getPeso() > this.getPesoMax())||attrezzo==null)
			return false;
		else
		return attrezzi.add(attrezzo);
	}
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatoreAttrezzi compAtt=new ComparatoreAttrezzi();
		this.attrezzi.sort(compAtt);
		return attrezzi;
	}
	public SortedSet<Attrezzo> getContenuroOrdinatoPerNome(){
		SortedSet<Attrezzo> attrezziOrdinati= new TreeSet<>();
		attrezziOrdinati.addAll(attrezzi);
		return attrezziOrdinati;
	}
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
	 Map<Integer,Set<Attrezzo>> Map=new HashMap<>();
	 Set<Attrezzo> tmp;
	 for(Attrezzo attrezzo: this.attrezzi) {
		 tmp=Map.get(attrezzo.getPeso());
		 if(tmp==null) {
			 tmp= new HashSet<>();
			 Map.put(attrezzo.getPeso(), tmp);
		 }
		 tmp.add(attrezzo);
	 }
	 return Map;
	}
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezzi compAtt=new ComparatoreAttrezzi();
		SortedSet<Attrezzo> set=new TreeSet<>(compAtt);
		for(Attrezzo attrezzo:this.attrezzi)
			set.add(attrezzo);
		return set;
		
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
				if(attrezzo.getNome().equals(nomeAttrezzo)) {
					a=attrezzo; 
					this.attrezzi.remove(attrezzo);
					 break;}
		}
		return a;
	}}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Peso borsa: ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg):\n ");
			for(Attrezzo attrezzo:this.attrezzi)
				s.append(attrezzo.getNome()+" "+attrezzo.getPeso()+"kg\n ");
				
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}



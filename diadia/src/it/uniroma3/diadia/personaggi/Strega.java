package it.uniroma3.diadia.personaggi;
import java.util.*;
import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	private static final String PRESENTAZIONE="Ciao sono una strega e mi chiamo ";
	private static final String NO_SALUTO="Sei un po' scortese";
	private static final String SALUTO="La strega ti ha teletrasportato";
	private static final String RISATA="hahahahahahah";
	
	public Strega(String nome) {
		super(nome,PRESENTAZIONE+nome);
	}
	@Override
	public String agisci(Partita partita){
	Stanza stanza=partita.getLabirinto().getStanzaCorrente();
	String msg;
		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(stanzaConMaxAtt(stanza.getMapStanzeAdiacenti()));	
			msg=SALUTO;
	}
			else {
			partita.getLabirinto().setStanzaCorrente(stanzaConMinAtt(stanza.getMapStanzeAdiacenti()));	
			msg=NO_SALUTO;}
		return msg;
	}
	public Stanza stanzaConMaxAtt(Map<String,Stanza> mappa) {
		boolean maxSegnato=false;
		Stanza max=null;
		for(Map.Entry<String, Stanza> entry:mappa.entrySet()) {
			if(!maxSegnato) {
				max=entry.getValue();
				maxSegnato=true;}
			else if(entry.getValue().getAttrezzi().size()>max.getAttrezzi().size())
				max=entry.getValue();
		}
		return max;}
	
	public Stanza stanzaConMinAtt(Map<String,Stanza> mappa) {
		boolean minSegnato=false;
		Stanza min=null;
		for(Map.Entry<String, Stanza> entry:mappa.entrySet()) {
			if(!minSegnato) {
				min=entry.getValue();
				minSegnato=true;}
			else if(entry.getValue().getAttrezzi().size()>min.getAttrezzi().size())
				min=entry.getValue();
		}
		return min;}
	@Override
	public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return RISATA;
	}
}

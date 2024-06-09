package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String VERSO="Bau";
	private static final String MORSO="Sei stato morso dal cane";
	private static final String ATTREZZO="Il cane ha posato un ";
	private String attrezzoPreferito;
	private Attrezzo attrezzoChePosa;
	public Cane(String nome,String attrezzoPreferito,String nomeAttPosato,int pesoAtt) {
		super(nome,VERSO);
		this.attrezzoPreferito=attrezzoPreferito;
		attrezzoChePosa=new Attrezzo(nomeAttPosato,pesoAtt);
		
	}
	@Override
	public String agisci(Partita partita) {
		String msg=MORSO;
		int cfu=partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(--cfu);
		return msg;
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
		if(!attrezzo.getNome().equals(attrezzoPreferito))
		return this.agisci(partita);	
		else {
			StringBuilder msg=new StringBuilder();
			msg.append(ATTREZZO);
			msg.append(attrezzoChePosa.getNome());
			
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoChePosa);
			return msg.toString();
			
	}
}}

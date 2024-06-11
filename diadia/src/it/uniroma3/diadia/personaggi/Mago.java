package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String PRESENTAZIONE="Ciao sono un mago e mi chiamao ";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String REGALO="Il mago ti posato il tuo regalo a terra";
	private static final String GIA_REGALATO="Questo oggetto me l'hai già dato";
	private Attrezzo attrezzo;
	
	public Mago(String nome, Attrezzo attrezzo) {
		super(nome, PRESENTAZIONE+nome);
		this.attrezzo = attrezzo;
}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
	}	
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(!attrezzo.isRegalato()) {
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		int nuovopeso=attrezzo.getPeso()/2; 
		attrezzo.setPeso(nuovopeso);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		return REGALO;}
		else
			return GIA_REGALATO;
	}
	}
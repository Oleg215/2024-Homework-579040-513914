package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO{
	
	private List<String> rigaLetta;
	private List<String> messaggioStampato;
	private int riga;
	private int message;
	private int messaggioMostrato;

	
	public IOSimulator(List<String> rigaLetta) {
		super();
		this.rigaLetta = new ArrayList<>();
		this.messaggioStampato = new ArrayList<>();
		this.message = message;
		this.riga=riga;
		this.messaggioMostrato = messaggioMostrato;
	}

/* Il metodo mostraMessaggio() consentirà di conoscere i 
messaggi stampati durante la partita (a supporto di eventuali 
asserzioni) */
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggioStampato.add(this.message, messaggio);
		message++;
		
	}

/* Il metodo leggiRiga() consentirà di “iniettare” le righe che 
desideriamo far figurare come istruzioni (di solito immesse 
dall’utente) */
	@Override
	public String leggiRiga() {
		String rigaletta = null;
		
		rigaletta = this.rigaLetta.get(riga);
		riga++;
		return rigaletta;
	}

	public List<String> getRigaLetta() {
		return rigaLetta;
	}

	public void setRigaLetta(List<String> rigaLetta) {
		this.rigaLetta = rigaLetta;
	}

	public List<String> getMessaggioStampato() {
		return messaggioStampato;
	}

	public void setMessaggioStampato(List<String> messaggioStampato) {
		this.messaggioStampato = messaggioStampato;
	}
	
	public String nextMessaggio() {
		String next = this.messaggioStampato.get(messaggioMostrato);
		this.messaggioMostrato++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.messaggioMostrato < this.message;
	}
	

}
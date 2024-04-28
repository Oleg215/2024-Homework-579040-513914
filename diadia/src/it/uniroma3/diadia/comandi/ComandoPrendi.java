package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import  it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;
public class ComandoPrendi implements Command {
	private String nomeAttrezzo;
	
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			System.out.println("inserire oggetto da prendere");
		return;}
		Stanza StanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		if(StanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo att=StanzaCorrente.getAttrezzo(nomeAttrezzo);
			StanzaCorrente.removeAttrezzo(att);
			if(partita.getGiocatore().getBorsa().addAttrezzo(att))
				System.out.println("oggetto aggiunto");
			else
				System.out.println("impossibile prendere");}
		else
			System.out.println("oggetto non è nella stanza");
		
		
	}
	
	@Override
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

package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String nomeAttrezzoSbloccante;	

	public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
	}

/* 
– se nella stanza non è presente l'attrezzo 
sbloccante, il metodo ritorna un riferimento alla 
stanza corrente
– altrimenti ha l’usuale comportamento (ritorna la 
stanza corrispondente all'uscita specificata)
*/
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!(this.hasAttrezzo(nomeAttrezzoSbloccante)))
			return this;
		return this.getStanzaAdiacente(direzione);
	
	}
	
/* 
Dentro la classe StanzaBloccata riscrivere 
anche il metodo getDescrizione() affinché 
produca una descrizione opportuna.
Anche in questo caso il nome dell'attrezzo 
sbloccante (ad es. ‘piedediporco’) e il nome 
della direzione bloccata vanno impostati 
attraverso il costruttore
 */	
	@Override
	public String getDescrizione() {
		String descrizione = "Stanza bloccata nella direzione " + direzioneBloccata + ". Prendi il " + nomeAttrezzoSbloccante +  " che consente di sbloccare la direzione bloccata\n";

		if(!this.hasAttrezzo(nomeAttrezzoSbloccante))
			return descrizione;
		return super.getDescrizione();
	}
}
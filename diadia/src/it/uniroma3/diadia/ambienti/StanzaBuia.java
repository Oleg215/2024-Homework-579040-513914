package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	static final String OGGETTO_DEFAULT="lanterna";
	private String oggetto;
	public StanzaBuia(String nome) {
		this(nome,OGGETTO_DEFAULT);
		
	}
	public StanzaBuia(String nome,String oggetto) {
		super(nome);
		this.oggetto=oggetto;
	}
	public String getOggetto() {
		return this.oggetto;
	}
	@Override
	public String getDescrizione() {
		if(!(this.hasAttrezzo(this.oggetto))) {
			return "qui c'è buio pesto";
					
		}
		else
			return super.getDescrizione();
	}
	public String getDes() {
		return super.getDescrizione();
	}
}

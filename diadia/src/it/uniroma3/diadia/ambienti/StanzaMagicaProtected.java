package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
public class StanzaMagicaProtected extends StanzaProtected {
	final static private int SOGLIA_MAGICA_DEFAULT=3;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagicaProtected(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagicaProtected(String nome,int sogliaMagica) {
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica=sogliaMagica;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI) {
			if(this.contatoreAttrezziPosati>this.sogliaMagica)
				this.modificaAttrezzo(attrezzo);
			this.attrezzi[this.numeroAttrezzi]=attrezzo;
			this.numeroAttrezzi++;
			this.contatoreAttrezziPosati++;
			return true;
		}
		else {return false;}
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2=attrezzo.getPeso()*2;
		nomeInvertito= new StringBuilder(attrezzo.getNome());
		nomeInvertito= nomeInvertito.reverse();
		attrezzo=new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
		
	}


}

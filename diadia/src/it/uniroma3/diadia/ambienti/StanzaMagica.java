package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
public class StanzaMagica extends Stanza {
	
	final static private int SOGLIA_MAGICA_DEFAULT=3;
	
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	public StanzaMagica(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagica(String nome, int sogliaMagica) {
		super(nome);
		this.contatoreAttrezziPosati=0;
		this.sogliaMagica=sogliaMagica;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo=this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	
	
	
	/*public boolean addAttrezzo(Attrezzo attrezzo) {
	
		Attrezzo[] attrezzi= this.getAttrezzi();
		int numeroAttrezzi=this.getNumeroAttrezzi();
		if(numeroAttrezzi<Stanza.NUMERO_MASSIMO_ATTREZZI()) {
			if(this.contatoreAttrezziPosati>this.sogliaMagica)
				this.modificaAttrezzo(attrezzo);
			attrezzi[this.getNumeroAttrezzi()]=attrezzo;
			this.setNumeroAttrezzi(++numeroAttrezzi);
			this.contatoreAttrezziPosati++;
			return true;
		}
		else {return false;}
				
		}*/
		private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
			StringBuilder nomeInvertito;
			int pesoX2=attrezzo.getPeso()*2;
			nomeInvertito= new StringBuilder(attrezzo.getNome());
			nomeInvertito= nomeInvertito.reverse();
			attrezzo=new Attrezzo(nomeInvertito.toString(),pesoX2);
			return attrezzo;
			
		}
	}


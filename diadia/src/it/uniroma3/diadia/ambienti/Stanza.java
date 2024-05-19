package it.uniroma3.diadia.ambienti;
import java.util.*;
import java.util.HashMap; 
import java.util.Map;
import java.util.ArrayList;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    private List<Attrezzo> attrezzi;
    private int numeroAttrezzi;
    private Map<String, Stanza> mappaStanzeAdiacenti;
    private int numeroStanzeAdiacenti;
  
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.mappaStanzeAdiacenti = new HashMap<>();
        this.attrezzi = new ArrayList<Attrezzo>();
    }
    public List<Attrezzo> getAttrezzi(){
    	return this.attrezzi;
    }
    public Map<String,Stanza> getMapStanzeAdiacenti(){
    	return this.mappaStanzeAdiacenti;
    }
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
    	if(mappaStanzeAdiacenti.containsKey(direzione)) {
    		this.mappaStanzeAdiacenti.put(direzione, stanza);
    		aggiornato = true;
    	}
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.mappaStanzeAdiacenti.put(direzione, stanza);
    		    this.numeroStanzeAdiacenti++;
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
		if(mappaStanzeAdiacenti.containsKey(direzione))
			stanza=this.mappaStanzeAdiacenti.get(direzione);
        return stanza;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
//    public Attrezzo[] getAttrezzi() {
//        return this.attrezzi;
//    }
   
    
    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if (this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.add(attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }
 

	static public int NUMERO_MASSIMO_ATTREZZI() {
    	return Stanza.NUMERO_MASSIMO_ATTREZZI;
    }
    public void setNumeroAttrezzi(int n) {
    	this.numeroAttrezzi=n;
    }
   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	Set<String> direzioni=this.getDirezioni();
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	
    	for (String direzione : direzioni)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for(Attrezzo attrezzo:this.attrezzi)
    			risultato.append(attrezzo.getNome()+" ");
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato=false;
		Iterator<Attrezzo> i= attrezzi.iterator();
		while(i.hasNext()&&!trovato) {
			Attrezzo attrezzo=i.next();
			if(attrezzo.getNome().equals(nomeAttrezzo))
				trovato=true;
		}
		return trovato;
		
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		boolean trovato=false;
		attrezzoCercato = null;
		if(this.hasAttrezzo(nomeAttrezzo)) {
		Iterator<Attrezzo> i= attrezzi.iterator();
		while(i.hasNext()&&!trovato) {
			Attrezzo attrezzo=i.next();
			if(attrezzo.getNome().equals(nomeAttrezzo)) {
				trovato=true;
				attrezzoCercato=attrezzo;
		}}}
		return attrezzoCercato;
	}
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null) {
			return this.attrezzi.remove(attrezzo);
			}
		
		else
			return false;
	}
		
	public boolean isFull() {
		return this.numeroAttrezzi==NUMERO_MASSIMO_ATTREZZI;
	}
	
	public Set<String> getDirezioni() {
		Set<String>direzioni=this.mappaStanzeAdiacenti.keySet();
		return direzioni;
		/*String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;*/
    }
	public boolean isMagica() {
		return false;
	}

}
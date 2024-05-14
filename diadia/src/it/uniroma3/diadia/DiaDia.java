package it.uniroma3.diadia;
import it.uniroma3.diadia.comandi.*; 

import java.util.Scanner;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	

	private Partita partita;
	private IO io;

	public DiaDia(IO console,Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.io = console;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do
			istruzione=io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
//		System.out.println("prova");
		Command comandoDaEseguire;
		FabbricaComandiFisarmonica factory= new FabbricaComandiFisarmonica();
		comandoDaEseguire=factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if(this.partita.vinta())
			System.out.println("Congratulazioni hai vinto");
		if(!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU");
		return this.partita.isFinita();
		}   


	public static void main(String[] argc) {
		IO console = new IOConsole();
		Labirinto labirinto=new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("osso", 1)
			.addStanzaVincente("Biblioteca")
			.addStanza("Aula N10")
			.addAttrezzo("lanterna", 3)
			.addStanza("Aula N11")
			.addStanza("Laboratorio Campus")
			.addAdiacenza("Atrio","Biblioteca","nord")
			.addAdiacenza("Atrio","Aula N11","est")
			.addAdiacenza("Atrio","Aula N10","sud")
			.addAdiacenza("Atrio","Laboratorio Campus","ovest")
			.addAdiacenza("Aula N11","Laboratorio Campus","est")
			.addAdiacenza("Aula N11","Atrio","ovest")
			.addAdiacenza("Aula N10", "Atrio","nord")
			.addAdiacenza("Aula N10", "Aula N11","est")
			.addAdiacenza("Aula N10", "Laboratorio Campus","ovest")
			.addAdiacenza("Laboratorio Campus","Atrio", "est")
			.addAdiacenza("Laboratorio Campus","Aula N11", "ovest")
			.addAdiacenza("Biblioteca", "Atrio", "sud").getLabirinto();

		DiaDia gioco = new DiaDia(console,labirinto);
		gioco.gioca();
	}
}
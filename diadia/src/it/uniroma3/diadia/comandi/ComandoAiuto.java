package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Command {
		static final private String[] elencoComandi= {"vai","aiuto","fine","prendi","posa","guarda"};
		public void esegui(Partita partita) {
			for(int i=0; i<elencoComandi.length;i++)
				System.out.println(elencoComandi[i]+" ");
		}
		@Override
		public void setParametro(String parametro) {}
		
	

}

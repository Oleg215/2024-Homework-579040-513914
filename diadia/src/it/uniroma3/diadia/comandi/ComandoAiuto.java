package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
		static final private String[] elencoComandi= {"vai","aiuto","fine","prendi","posa","guarda","regala"};
		public void esegui(Partita partita) {
			for(int i=0; i<elencoComandi.length;i++)
				System.out.println(elencoComandi[i]+" ");
		}
		@Override
		public void setParametro(String parametro) {}
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

package it.uniroma3.diadia.comandi;

public abstract class AbstractComando implements Command{

	private String parametro;

	public String getParametro() {
		return this.parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	
}

package it.uniroma3.diadia.attrezzi;
import java.util.Comparator;
public class ComparatoreAttrezzi implements Comparator<Attrezzo> {
	@Override
	public int compare(Attrezzo a1,Attrezzo a2) {
		if(a1.getPeso()-a2.getPeso()!=0)
			return a1.getPeso()-a2.getPeso();
		else
			return 
				a1.compareTo(a2);
	}

}

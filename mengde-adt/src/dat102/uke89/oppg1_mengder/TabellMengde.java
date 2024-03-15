package dat102.uke89.oppg1_mengder;
import java.util.Arrays;
public class TabellMengde<T> implements MengdeADT<T>{
	private static final int DEFAULT_KAPASITET = 10;

	private T[] tabell;
	private int antall;
	
	@Override
	public boolean erTom() {
		return antall==0;
	}

	@Override
	public boolean inneholder(Object element) {
		Boolean Ok=false;
		for(int i=0; i<antall;i++) {
			T x = tabell[i];
			if(x.equals(element)) {
				Ok=true;
			}
		}
		return Ok;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
	for(int i=0;i<antall;i++) {
		if(!annenMengde.inneholder(tabell[i])) {
			return false;
		}
	}
	return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if(annenMengde.antallElementer()!=antall) {
			return false;
		}
		for(int i=0;i<antall;i++) {
			if(!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
	return true;
	}


	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for(int i=0;i<antall;i++) {
			if(annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
	return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		
		TabellMengde<T> snittMengde =new TabellMengde<>();
		for(int i=0;i<antall;i++) {
			if(annenMengde.inneholder(tabell[i])) {
				snittMengde.leggTil(tabell[i]);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		TabellMengde<T> unionMengde = new TabellMengde<>();
		unionMengde.leggTilAlleFra(this);
		unionMengde.leggTilAlleFra(annenMengde);
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		TabellMengde<T>minusMengde= new TabellMengde<>();
		for(int i=0;i<antall;i++) {
			if(!annenMengde.inneholder(tabell[i])) {
				minusMengde.leggTil(tabell[i]);
			}
		}
		return minusMengde;
	}

	@Override
	public void leggTil(T element) {
			if(antall==tabell.length) {
				tabell=Arrays.copyOf(tabell,tabell.length*2);
		
		}
			if(inneholder(element)) {
				tabell[antall]=element;
				antall++;
			}
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for(int i=0; i< annenMengde.antallElementer();i++) {
			leggTil(annenMengde.tilTabell()[i]);
		}
		
	}

	@Override
	public T fjern(T element) {
		for(int i=0;i<antall;i++) {
				if(tabell[i].equals(element)) {
				T fjernetElement=tabell[i];
			for(int j=0;j<antall-1;j++) {
				tabell[j]=tabell[j+1];
				}
			tabell[antall-1]=null;
			antall--;
			return fjernetElement;
		}
	
	}
		return null;	
	}
	@Override
	public T[] tilTabell() {
		return Arrays.copyOf(tabell,antall);
			
	}

	@Override
	public int antallElementer() {
		
		return antall;
	}
	
	
}


package dat102.uke89.oppg1_mengder;
import java.util.Set;
import java.util.HashSet;


public class JavaSetToMengde<T> implements MengdeADT<T> {
private Set<T>sett;

public JavaSetToMengde() {
	sett= new HashSet<>();
	
}
	
	@Override
	public boolean erTom() {
		return sett.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		return sett.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for(T element :sett) {
			if(!annenMengde.inneholder(element)) {
				return false;
			}
		}
	return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if(annenMengde.antallElementer()!=sett.size()){
			return false;
		}
		for(T element:sett) {
			if(!annenMengde.inneholder(element)) {
				return false;
			}
		}
			return true;
			
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for(T element:sett) {
			if(annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T>snittMengde=new JavaSetToMengde<>();
		for(T element: sett) {
			if(annenMengde.inneholder(element)) {
			snittMengde.leggTil(element);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T>unionMengde =new JavaSetToMengde<>();
		unionMengde.leggTilAlleFra(this);
		unionMengde.leggTilAlleFra(annenMengde);
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T>differensMengde=new JavaSetToMengde<>();
		for(T element:sett) {
			if(!annenMengde.inneholder(element)) {
				differensMengde.leggTil(element);
			}
		}
		return differensMengde;
	}

	@Override
	public void leggTil(T element) {
		sett.add(element);
		
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for(T element: annenMengde.tilTabell()) {
			leggTil(element);
			
		}
	}

	@Override
	public T fjern(T element) {
	if(sett.remove(element)) {
		return element;
		
	} else {
		return null;
	}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] tilTabell() {
		
		T[]array=(T[])new Object[sett.size()];
		int index=0;
	for(T element: sett) {
		array[index++]=element;
	}
	return array;
	}

	@Override
	public int antallElementer() {
		return sett.size();
		
	}
	

}

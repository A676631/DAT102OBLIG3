package OppgaveF;

	import java.util.*;

	public class Person {
	    private String navn;
	    private Set<String> hobbyer;

	    public Person(String navn, String ... hobbyer) {
	        this.navn = navn;
	        this.hobbyer = new HashSet<>(Arrays.asList(hobbyer));
	    }

	    public String getNavn() {
	        return navn;
	    }

	    public Set<String> getHobbyer() {
	        return hobbyer;
	    }
	}



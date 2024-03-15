package Oppgave1f;
import java.util.*;

public class Personer {

    private String navn;
    private Set<String> hobbyer;

    public Personer(String navn, String ... hobbyer) {
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



package OppgaveF;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {

    static double match(Person a, Person b) {
        Set<String> fellesHobbyer = new HashSet<>(a.getHobbyer());
        fellesHobbyer.retainAll(b.getHobbyer());
        
        Set<String> kunHosA = new HashSet<>(a.getHobbyer());
        kunHosA.removeAll(b.getHobbyer());
        
        Set<String> kunHosB = new HashSet<>(b.getHobbyer());
        kunHosB.removeAll(a.getHobbyer());
        
        int antallFelles = fellesHobbyer.size();
        int antallKunHosDenEne = kunHosA.size();
        int antallKunHosDenAndre = kunHosB.size();
        int antallTotalt = a.getHobbyer().size() + b.getHobbyer().size() - antallFelles;
        
        return antallFelles - (double)(antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt;
    }

    public static void main(String[] args) {
        Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
        Person bea = new Person("Bea", "løping", "sykling", "venner", "dansing");
        Person camilla = new Person("Camilla", "klatring", "data", "venner");

        System.out.println("Match mellom Arne og Bea: " + match(arne, bea));
        System.out.println("Match mellom Bea og Arne: " + match(bea, arne));
        System.out.println("Match mellom Arne og Camilla: " + match(arne, camilla));
        System.out.println("Match mellom Bea og Camilla: " + match(bea, camilla));
        System.out.println("Match mellom Arne og Arne (selv-match): " + match(arne, arne));
    }
}




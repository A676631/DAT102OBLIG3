package Oppgave1f;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {

    static double match(Personer a, Personer b) {
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
        Personer arne = new Personer("Arne", "jakt", "sykling", "venner", "data");
        Personer bea = new Personer("Bea", "løping", "sykling", "venner", "dansing");
        Personer camilla = new Personer("Camilla", "klatring", "data", "venner");

        System.out.println("Match mellom Arne og Bea: " + match(arne, bea));
        System.out.println("Match mellom Bea og Arne: " + match(bea, arne));
        System.out.println("Match mellom Arne og Camilla: " + match(arne, camilla));
        System.out.println("Match mellom Bea og Camilla: " + match(bea, camilla));
        System.out.println("Match mellom Arne og Arne (selv-match): " + match(arne, arne));
    }
}




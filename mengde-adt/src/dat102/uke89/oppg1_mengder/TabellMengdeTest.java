package dat102.uke89.oppg1_mengder;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabellMengdeTest {

    private TabellMengde<Integer> mengde;

    @BeforeEach
    public void oppsett() {
        mengde = new TabellMengde<>();
    }

    @Test
    public void leggTilOgInneholderTest() {
        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(3);

        assertTrue(mengde.inneholder(1));
        assertTrue(mengde.inneholder(2));
        assertTrue(mengde.inneholder(3));
        assertFalse(mengde.inneholder(4));
    }

    @Test
    public void leggTilAlleFraTest() {
        TabellMengde<Integer> annenMengde = new TabellMengde<>();
        annenMengde.leggTil(4);
        annenMengde.leggTil(5);

        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTilAlleFra(annenMengde);

        assertTrue(mengde.inneholder(1));
        assertTrue(mengde.inneholder(2));
        assertTrue(mengde.inneholder(4));
        assertTrue(mengde.inneholder(5));
    }

    @Test
    public void fjernTest() {
        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(3);

        assertEquals(2, mengde.fjern(2));
        assertFalse(mengde.inneholder(2));
        assertEquals(3, mengde.fjern(3));
        assertFalse(mengde.inneholder(3));
        assertNull(mengde.fjern(4));
    }

    @Test
    public void snittTest() {
        TabellMengde<Integer> annenMengde = new TabellMengde<>();
        annenMengde.leggTil(2);
        annenMengde.leggTil(3);

        mengde.leggTil(1);
        mengde.leggTil(2);
        mengde.leggTil(4);

        MengdeADT<Integer> snitt = mengde.snitt(annenMengde);

        assertTrue(snitt.inneholder(2));
        assertFalse(snitt.inneholder(1));
        assertFalse(snitt.inneholder(3));
        assertFalse(snitt.inneholder(4));
    }
    
    
}

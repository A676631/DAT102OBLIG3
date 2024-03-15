package dat102.uke89.oppg1_mengder;

import static org.junit.jupiter.api.Assertions.*;

import dat102.uke89.oppg1_mengder.TabellMengde;
import dat102.uke89.oppg1_mengder.MengdeADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabellMengdeTest {
    private MengdeADT<Integer> set;

    @BeforeEach
    public void setUp() {
        set = new TabellMengde<>();
        set.leggTil(1);
        set.leggTil(2);
        set.leggTil(3);
    }

    @Test
    public void testErTom() {
        assertFalse(set.erTom());
    }

    @Test
    public void testInneholder() {
        assertTrue(set.inneholder(2));
        assertFalse(set.inneholder(4));
    }

    @Test
    public void testErDelmengdeAv() {
        TabellMengde<Integer> subset = new TabellMengde<>();
        subset.leggTil(2);
        assertTrue(subset.erDelmengdeAv(set));
    }

    @Test
    public void testErLik() {
        TabellMengde<Integer> equalSet = new TabellMengde<>();
        equalSet.leggTil(1);
        equalSet.leggTil(2);
        equalSet.leggTil(3);
        assertTrue(set.erLik(equalSet));
    }

    @Test
    public void testErDisjunkt() {
        TabellMengde<Integer> disjointSet = new TabellMengde<>();
        disjointSet.leggTil(4);
        disjointSet.leggTil(5);
        assertTrue(set.erDisjunkt(disjointSet));
    }

    @Test
    public void testSnitt() {
        TabellMengde<Integer> otherSet = new TabellMengde<>();
        otherSet.leggTil(2);
        otherSet.leggTil(3);
        MengdeADT<Integer> intersection = set.snitt(otherSet);
        assertTrue(intersection.inneholder(2));
        assertTrue(intersection.inneholder(3));
        assertFalse(intersection.inneholder(1));
    }

    @Test
    public void testUnion() {
        TabellMengde<Integer> otherSet = new TabellMengde<>();
        otherSet.leggTil(3);
        otherSet.leggTil(4);
        MengdeADT<Integer> union = set.union(otherSet);
        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
        assertTrue(union.inneholder(4));
    }

    @Test
    public void testMinus() {
        TabellMengde<Integer> otherSet = new TabellMengde<>();
        otherSet.leggTil(2);
        otherSet.leggTil(4);
        MengdeADT<Integer> difference = set.minus(otherSet);
        assertTrue(difference.inneholder(1));
        assertTrue(difference.inneholder(3));
        assertFalse(difference.inneholder(2));
        assertFalse(difference.inneholder(4));
    }

    @Test
    public void testLeggTil() {
        set.leggTil(4);
        assertTrue(set.inneholder(4));
    }

    @Test
    public void testLeggTilAlleFra() {
        TabellMengde<Integer> otherSet = new TabellMengde<>();
        otherSet.leggTil(4);
        otherSet.leggTil(5);
        set.leggTilAlleFra(otherSet);
        assertTrue(set.inneholder(4));
        assertTrue(set.inneholder(5));
    }

    @Test
    public void testFjern() {
        Integer removed = set.fjern(2);
        assertTrue(removed == 2);
        assertFalse(set.inneholder(2));
    }

    @Test
    public void testAntallElementer() {
        assertEquals(3, set.antallElementer());
    }
}

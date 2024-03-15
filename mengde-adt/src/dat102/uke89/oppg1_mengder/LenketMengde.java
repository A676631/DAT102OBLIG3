package dat102.uke89.oppg1_mengder;



	public class LenketMengde<T> implements MengdeADT<T> {
	private class Node {

	private T data;
	private Node neste;

	private Node(T data) {
	this.data = data;
	this.neste = null;
	}
	}


	private Node første;
	private int antall;

	public LenketMengde() {
	første = null;
	antall = 0;
	}

	@Override
	public boolean erTom() {
	return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
	Node temp = første;
	while(temp!=null) {
	if(temp.data.equals(element)) {
	return true;
	}
	temp = temp.neste;
	}
	return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
	if(antall > annenMengde.antallElementer()) {
	return false;
	}
	Node temp = første;
	while(temp != null) {
	if(!annenMengde.inneholder(temp.data)) {
	return false;
	}
	temp = temp.neste;
	}
	return true;

	}


	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
	if(antall != annenMengde.antallElementer()) {
	return false;
	}
	Node temp = første;
	while(temp != null) {
	if(!annenMengde.inneholder(temp.data)) {
	return false;
	}
	temp = temp.neste;
	}
	return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
	Node temp = første;
	while(temp != null) {
	if(annenMengde.inneholder(temp.data)) {
	return false;
	}
	temp = temp.neste;
	}
	return true;

	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
	TabellMengde<T> snittMengde = new TabellMengde<>();
	Node temp = første;
	while(temp != null) {
	if(annenMengde.inneholder(temp.data)) {
	snittMengde.leggTil(temp.data);
	}
	temp = temp.neste;
	}
	return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
	TabellMengde<T> unionMengde = new TabellMengde<>();
	Node temp = første;
	while(temp != null) {
	if(!annenMengde.inneholder(temp.data)) {
	unionMengde.leggTil(temp.data);}
	temp = temp.neste;
	}
	T[] tabell = annenMengde.tilTabell();
	for(int i = 0; i < tabell.length; i++) {
	unionMengde.leggTil(tabell[i]);
	}
	return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
	MengdeADT<T> minusMengde = new TabellMengde<>();
	Node temp = første;
	while(temp != null) {
	if(!annenMengde.inneholder(temp.data)) {
	minusMengde.leggTil(temp.data);
	}
	temp = temp.neste;
	}
	return minusMengde;
	}

	@Override
	public void leggTil(T element) {
	Node nyNode = new Node(element);
	if(første == null) {
	første = nyNode;
	}else {
	Node temp = første;
	while(temp.neste != null) {
	temp = temp.neste;
	}
	temp.neste = nyNode;
	}
	antall++;
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
	T[] tab = annenMengde.tilTabell();
	for(T i : tab) {
	leggTil(i);
	}

	}

	@Override
	public T fjern(T element) {
	Node gjeldende = første;
	Node forrige = null;
	while(gjeldende != null) {
	if(gjeldende.data.equals(element)) {
	if(forrige == null) {
	første = gjeldende.neste;
	}
	else {
	forrige.neste = gjeldende.neste;
	}
	antall--;
	return gjeldende.data;
	}
	forrige = gjeldende;
	gjeldende = gjeldende.neste;
	}
	return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
	T[] tabell = (T[]) new Object[antall];

	Node temp = første;
	int indeks = 0;
	while (temp != null) {
	tabell[indeks] = temp.data;
	temp = temp.neste;
	indeks++;
	}

	return tabell;
	}


	@Override
	public int antallElementer() {
	return antall;
	}
	
	}


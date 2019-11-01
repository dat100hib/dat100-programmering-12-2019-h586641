package no.hvl.dat100.jplab12.oppgave1;

import no.hvl.dat100.jplab12.common.TODO;

public abstract class Innlegg {
	
	// TODO - deklarering av objektvariable
	protected int id;
	protected String bruker;
	protected String dato;
	protected int likes;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {

		// TODO 
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		likes = 0;
		
//		throw new UnsupportedOperationException(TODO.constructor("Innlegg"));
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// TODO - START
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
		
//		throw new UnsupportedOperationException(TODO.constructor("Innlegg"));
	}
	
	public String getBruker() {
		
		return bruker;
//		throw new UnsupportedOperationException(TODO.method());

	}

	public void setBruker(String bruker) {
		
		this.bruker = bruker;
		
//		throw new UnsupportedOperationException(TODO.method());
	}

	public String getDato() {
		
		return dato;
//		throw new UnsupportedOperationException(TODO.method());
		
	}

	public void setDato(String dato) {
		
		this.dato = dato;
//		throw new UnsupportedOperationException(TODO.method());
	}

	public int getId() {
		
		return id;
//		throw new UnsupportedOperationException(TODO.method());

	}

	/* øker antall likes for innlegget med 1. */
	public int getLikes() {	
		return likes;
//		throw new UnsupportedOperationException(TODO.method());

	}
	
	public void doLike () {
		likes++;
//		throw new UnsupportedOperationException(TODO.method());
	}
	
	/* returnerer true hvis og kun hvis innlegget har samme id som innlegget innlegg 
	 * git med som parameter */
	public boolean erLik(Innlegg innlegg) {
		if (this.id == innlegg.id) {
			return true;
		} else {
			return false;
		}
//		throw new UnsupportedOperationException(TODO.method());

	}
	
	@Override
	public String toString() {
		return (id + "\n" + bruker + "\n" + dato + "\n" + likes + "\n");		
//		throw new UnsupportedOperationException(TODO.method());
				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		return ("<h2>" + bruker + "@" + dato + " [" + likes + "]</h2>");
//		throw new UnsupportedOperationException(TODO.method());
				
	}
}

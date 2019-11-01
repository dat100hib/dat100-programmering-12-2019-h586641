package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] innleggTabell;
	private int nesteLedig;

	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedig = 0;
		//		throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedig = 0;
		//		throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public int getAntall() {
		return nesteLedig;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public Innlegg[] getSamling() {
		return innleggTabell;
		//		throw new UnsupportedOperationException(TODO.method());

	}

	public int finnInnlegg(Innlegg innlegg) {
		int i = 0;
		int pos = -1;

		while ( ( i < nesteLedig) && (pos == -1)) {
			if (innleggTabell[i].erLik(innlegg)) {
				pos = i;
			}
			i++;
		}
		return pos;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean finnes(Innlegg innlegg) {

		return finnInnlegg(innlegg) != -1;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean ledigPlass() {
		return (nesteLedig < innleggTabell.length);
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		if (!finnes(innlegg)) {
			innleggTabell[nesteLedig] = innlegg;
			nesteLedig++;
			lagtTil = true;
		}
		return lagtTil;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public String toString() {
		String tekst = Integer.toString(nesteLedig) + "\n";
		for (int i = 0; i < nesteLedig; i++) {
			tekst += innleggTabell[i].toString();
		}
		return tekst;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor

	/* VALGFRI: metode som oppretter en ny tabell av innlegg-objekt som er 
	 * dobbelt så stor og flytter elementene over i denne. */
	public void utvid() {
		Innlegg[] newTabell = new Innlegg[2*innleggTabell.length];

		for (int i = 0; i < nesteLedig; i++) {
			newTabell[i] = innleggTabell[i];
		}
		innleggTabell = newTabell;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = false;

		if (!finnes(innlegg)) {
			if (!ledigPlass()) {
				utvid();
			}
			innleggTabell[nesteLedig] = innlegg;
			nesteLedig++;
			lagtTil = true;
		}
		return lagtTil;
		//		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		if (finnes(innlegg)) {
			innleggTabell[finnInnlegg(innlegg)] = innleggTabell[nesteLedig-1];
			innleggTabell[nesteLedig-1] = null;
			nesteLedig--;
			slettet = true;
			
		}
		return slettet;

		//		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String ord) {
			
		/* Teller antall forekomster av "ord" for å bestemme størrelsen av tabellen */
		int[] tab = new int[nesteLedig];
		
		int j = 0;
		for (int i = 0; i < nesteLedig; i++) {
			Innlegg il = innleggTabell[i];
			if ( il instanceof Tekst) {
				Tekst t = (Tekst)il;	// typetvang
				if (t.getTekst().contentEquals(ord)) {
					tab[j] = t.getId();
					j++;
				}
			}
		}
		
		/* lager en ny tabell av id med passende størrelse */		
		int[] newTab = new int[j];
		for (int i = 0; i < j; i++) {
			newTab[i] = tab[i];
		}
				
		return newTab;
//		throw new UnsupportedOperationException(TODO.method());

	}
	
	/* Oppgave 6 */
	public String toHTML() {
		String tekst = "";
		for (int i = 0; i < nesteLedig; i++) {
			tekst += innleggTabell[i].toHTML();
			tekst += "<hr>";
		}
		return tekst;
		//		throw new UnsupportedOperationException(TODO.method());
	}
}
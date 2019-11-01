package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.oppgave4.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {

		try {
			/* Åpne fil */
			File file = new File(MAPPE + filnavn);

			BufferedReader leser
			= new BufferedReader(new FileReader(file));

			/* Antall blogginnlegg ligger på første linje */
			String firstLine = leser.readLine();
			int antallInnlegg = Integer.parseInt(firstLine);
			Blogg b = new Blogg(antallInnlegg);

			/* Leser linjene */
			Boolean lagtTil = false;
			while (leser.ready()) {
				String innleggType = leser.readLine();
				int id = Integer.parseInt(leser. readLine());
				String bruker = leser.readLine();
				String dato = leser.readLine();
				int likes = Integer.parseInt(leser. readLine());
				String tekst = leser.readLine();
				
				/* leser innleggtype, oppretter innlegg og legger til i blogg */
				switch (innleggType) {
				case "TEKST":
					Tekst nyTekst = new Tekst(id, bruker, dato, likes, tekst);
					lagtTil = b.leggTil(nyTekst);
					break;

				case "BILDE":
					String bilde = leser.readLine();
					Bilde nyttBilde = new Bilde(id, bruker, dato, tekst, bilde);
					lagtTil = b.leggTil(nyttBilde);
					break;
				}
			}

			/* Lukker fil */
			leser.close();
			return b;
		}

		catch (Exception e){
			System.out.println("Feil!");
			return null;
		}

		//		throw new UnsupportedOperationException(TODO.method());
	}
}

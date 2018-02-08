package nested.gebaeude;

import java.util.ArrayList;
import nested.gebaeude.Gebaeude.Stockwerk.Raum;

// Erzeugen Sie eine Klasse "Gebaeude", die der folgenden Beschreibungen entspricht 
// (benutzen Sie innere Klassen für die Typen "Stockwerk" und "Raum"):

// Ein Gebäude kann 1 oder mehrere Stockwerke haben. Ein Stockwerk hat mindestens 1 Raum.

// Definieren Sie für die Klasse "Gebaeude" einen Konstruktor, 
// an den Sie die den Strassennamen, die Hausnummer, die Anzahl von Stockwerke und 
// die Anzahl von Räumen pro Stockwerk übergeben können.

/**
 * @author Sergej Lavruhin
 *
 */
public class Gebaeude {
	String Strassennamen;
	String Hausnummer;
	ArrayList<Stockwerk> stockwerke = new ArrayList<Stockwerk>();
	
	class Stockwerk {
		int StockwerkNummer;
		ArrayList<Raum> raume = new ArrayList<Raum>();

		class Raum {
			int RaumNummer;
			
			Raum(int RaumNummer) {
				this.RaumNummer = RaumNummer;
			}
			
			@Override
			public String toString() {
				return String.format("%d.%d / %s %s", StockwerkNummer, RaumNummer, Strassennamen, Hausnummer);
			}
		}

		Stockwerk(int StockwerkNummer, int AnzahlRaeumen) {
			this.StockwerkNummer = StockwerkNummer;
			if(AnzahlRaeumen < 1)
				AnzahlRaeumen = 1;
			for(int i = 0 ; i < AnzahlRaeumen; ++i)
				raume.add(new Raum(i));
		}
		
		Raum get(int index) {
			return index < raume.size() ? raume.get(index) : null;
		}
	}

	Gebaeude(String Strassennamen, 
			 String Hausnummer, 
			 int AnzahlStockwerke, 
			 int AnzahlRaeumen) {	
		this.Strassennamen    = Strassennamen;
		this.Hausnummer       = Hausnummer;
		
		if(AnzahlStockwerke < 1)
			AnzahlStockwerke = 1;
		for(int i = 0 ; i < AnzahlStockwerke; ++i)
			stockwerke.add(new Stockwerk(i, AnzahlRaeumen));
	}

	// Definieren Sie für die Klasse "Gebaeude" die Methode getStockwerk(int stockwerkNr), 
	// die die Referenz auf das Objekt von Typ "Stockwerk" liefert.
	Stockwerk getStockwerk(int stockwerkNr) {
		return stockwerkNr < stockwerke.size() ? stockwerke.get(stockwerkNr) : null;
	}
	
	// Definieren Sie für die Klasse "Gebaeude" die Methode getRaum(int stockwerkNr, int raumNr), 
	// die die Referenz auf das Objekt von Typ "Raum" liefert.
	Raum getRaum(int stockwerkNr, int raumNr) {
		Stockwerk stockwerk = getStockwerk(stockwerkNr);
		return stockwerk != null ? stockwerk.get(raumNr) : null;
	}

	public static void main(String[] args) {
		// Erstellen Sie ein Objekt von Typ "Gebaeude". 
		// Dabei soll ein Gebäude auf der Hauptstr. 45 mit 3 Stockwerken und 10 Räume pro Stockwerk entstehen.
		Gebaeude gebaeude = new Gebaeude("Hauptstr.", "45" ,3 ,10);

		// Benutzen Sie die Methode "getRaum" für das erstellte Gebäude mit den Argumenten 0 und 2.
		Raum r = gebaeude.getRaum(0, 2);
		if(r != null)
			System.out.println(r);
	}
}
